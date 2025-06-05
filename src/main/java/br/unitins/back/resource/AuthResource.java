package br.unitins.back.resource;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.unitins.back.dto.AuthUsuarioDTO;
import br.unitins.back.dto.response.UsuarioResponseDTO;
import br.unitins.back.model.usuario.Usuario;
import br.unitins.back.repository.UsuarioRepository;
import br.unitins.back.service.PasswordResetService;
import br.unitins.back.service.hash.HashService;
import br.unitins.back.service.jwt.JwtService;
import br.unitins.back.service.usuario.UsuarioService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthResource.class);

    @Inject
    UsuarioService service;

    @Inject
    HashService hashService;

    @Inject
    JwtService jwtService;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    PasswordResetService passwordResetService;

    @POST
    public Response login(AuthUsuarioDTO authDTO) {
        LOGGER.info("Tentando login para o usuário: {}", authDTO.login());
        String hash = hashService.getHashSenha(authDTO.senha());
        LOGGER.debug("Hash da senha fornecida: {}", hash); // ← Para debug apenas

        Usuario usuario = usuarioRepository.findByLoginAndSenha(authDTO.login(), hash);

        if (usuario == null) {
            // Verificar se o usuário existe mas a senha está errada
            Usuario usuarioExistente = usuarioRepository.findByLogin(authDTO.login());
            if (usuarioExistente != null) {
                LOGGER.warn("Usuário {} existe, mas senha está incorreta", authDTO.login());
                LOGGER.debug("Senha armazenada no BD: {}", usuarioExistente.getSenha()); // ← Para debug apenas
            } else {
                LOGGER.warn("Usuário {} não encontrado", authDTO.login());
            }
            return Response.status(Status.UNAUTHORIZED)
                    .entity(Map.of("message", "Login ou senha inválidos")).build();
        }

        LOGGER.info("Login realizado com sucesso para usuário: {}", usuario.getLogin());
        UsuarioResponseDTO usuarioResponse = UsuarioResponseDTO.valueOf(usuario);

        return Response.ok(usuarioResponse)
                .header("Authorization", "Bearer " + jwtService.generateJwt(usuarioResponse))
                .build();
    }

    @POST
    @Path("/solicitar-recuperacao")
    public Response solicitarRecuperacaoSenha(Map<String, String> payload) {
        String loginOuEmail = payload.get("loginOuEmail");
        if (loginOuEmail == null || loginOuEmail.isBlank()) {
            return Response.status(Status.BAD_REQUEST).entity("Login ou e-mail é obrigatório.").build();
        }

        try {
            service.requestPasswordReset(loginOuEmail);
            return Response.ok("Link de recuperação enviado, se o e-mail/login existir.").build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao solicitar recuperação.").build();
        }
    }

    @POST
    @Path("/resetar-senha")
    @Transactional // ← ADICIONAR esta anotação
    public Response redefinirSenha(Map<String, String> payload) {
        String token = payload.get("token");
        String novaSenha = payload.get("novaSenha");

        if (token == null || novaSenha == null || novaSenha.length() < 6) {
            return Response.status(Status.BAD_REQUEST)
                    .entity("Token ou nova senha inválidos.").build();
        }

        String emailOuLogin = passwordResetService.getEmailFromToken(token);
        if (emailOuLogin == null) {
            return Response.status(Status.BAD_REQUEST)
                    .entity("Token expirado ou inválido.").build();
        }

        // Buscar usuário de forma correta
        Usuario usuario = usuarioRepository.findByEmail(emailOuLogin);
        if (usuario == null) {
            usuario = usuarioRepository.findByLogin(emailOuLogin);
        }

        if (usuario == null) {
            LOGGER.warn("Usuário não encontrado para email/login: {}", emailOuLogin);
            return Response.status(Status.NOT_FOUND)
                    .entity("Usuário não encontrado").build();
        }

        // Log para debug
        LOGGER.info("Atualizando senha para usuário: {} (ID: {})", usuario.getLogin(), usuario.getId());

        // Definir nova senha
        String novaSenhaHash = hashService.getHashSenha(novaSenha);
        usuario.setSenha(novaSenhaHash);

        // Usar merge ao invés de persist para entidades existentes
        usuarioRepository.getEntityManager().merge(usuario);

        // Ou simplesmente não chame nada, pois a entidade já está managed dentro da transação
        // Log para confirmar
        LOGGER.info("Senha atualizada com sucesso para usuário ID: {}", usuario.getId());

        passwordResetService.invalidateToken(token);

        return Response.ok(Map.of("message", "Senha redefinida com sucesso!")).build();
    }
}

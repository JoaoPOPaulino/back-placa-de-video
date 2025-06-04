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
        LOGGER.debug("Hash gerado: {}", hash);
        UsuarioResponseDTO usuario = service.findByLoginAndSenha(authDTO.login(), hash);

        if (usuario == null) {
            LOGGER.warn("Usuário não encontrado para o login: {}", authDTO.login());
            return Response.status(Status.NOT_FOUND)
                    .entity("Usuario não encontrado").build();
        }
        LOGGER.info("Usuário encontrado: {}", usuario.login());
        return Response.ok(usuario)
                .header("Authorization", jwtService.generateJwt(usuario))
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
    public Response redefinirSenha(Map<String, String> payload) {
        String token = payload.get("token");
        String novaSenha = payload.get("novaSenha");

        if (token == null || novaSenha == null || novaSenha.length() < 6) {
            return Response.status(Status.BAD_REQUEST).entity("Token ou nova senha inválidos.").build();
        }

        String email = passwordResetService.getEmailFromToken(token);
        if (email == null) {
            return Response.status(Status.BAD_REQUEST).entity("Token expirado ou inválido.").build();
        }

        Usuario usuario = service.findByLogin(email) != null ? 
                        usuarioRepository.findByLogin(email) : 
                        usuarioRepository.findByEmail(email);

        if (usuario == null) {
            return Response.status(Status.NOT_FOUND).entity("Usuário não encontrado").build();
        }

        usuario.setSenha(hashService.getHashSenha(novaSenha));
        usuarioRepository.persist(usuario);

        passwordResetService.invalidateToken(token);

        return Response.ok("Senha redefinida com sucesso!").build();
    }

}

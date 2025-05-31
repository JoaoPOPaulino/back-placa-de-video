package br.unitins.back.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.unitins.back.dto.AuthUsuarioDTO;
import br.unitins.back.dto.response.UsuarioResponseDTO;
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
}

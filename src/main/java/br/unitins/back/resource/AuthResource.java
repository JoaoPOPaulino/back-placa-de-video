package br.unitins.back.resource;

import br.unitins.back.dto.LoginDTO;
import br.unitins.back.dto.response.UsuarioResponseDTO;
import br.unitins.back.service.hash.HashService;
import br.unitins.back.service.jwt.JwtService;
import br.unitins.topicos1.service.usuario.UsuarioService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
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

    @Inject
    UsuarioService service;

    @Inject
    HashService hashService;

    @Inject
    JwtService jwtService;

    @POST
    public Response login(@Valid LoginDTO dto) {
        String hashSenha = hashService.getHashSenha(dto.senha());

        UsuarioResponseDTO usuario = service.findByLoginAndSenha(dto.login(), hashSenha);

        if (usuario == null) {
            return Response.status(Status.NOT_FOUND)
                    .entity("Usuário não encontrado.")
                    .build();
        }

        return Response.ok()
                .header("Authorization", jwtService.generateJwt(usuario))
                .build();
    }
}

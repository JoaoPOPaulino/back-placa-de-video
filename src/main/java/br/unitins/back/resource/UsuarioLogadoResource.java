package br.unitins.back.resource;

import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.back.service.usuario.UsuarioService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuariologado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioLogadoResource {

    @Inject
    JsonWebToken jwt;

    @Inject
    UsuarioService usuarioService;

    @GET
    @RolesAllowed({"User", "Admin"})
    public Response getUsuario() {

        String login = jwt.getSubject();

        return Response.ok(usuarioService.findByLogin(login)).build();

    }
}

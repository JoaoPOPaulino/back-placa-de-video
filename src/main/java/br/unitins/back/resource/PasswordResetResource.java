package br.unitins.back.resource;

import br.unitins.back.service.PasswordResetService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/password-reset")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PasswordResetResource {
    @Inject
    PasswordResetService passwordResetService;

    @POST
    @Path("/request")
    public Response requestPasswordReset(@QueryParam("loginOrEmail") String loginOrEmail) {
        try {
            passwordResetService.requestPasswordReset(loginOrEmail);
            return Response.ok("E-mail de recuperação enviado com sucesso").build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuário não encontrado").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/reset")
    public Response resetPassword(@QueryParam("token") String token, @QueryParam("newPassword") String newPassword) {
        try {
            passwordResetService.resetPassword(token, newPassword);
            return Response.ok("Senha redefinida com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}

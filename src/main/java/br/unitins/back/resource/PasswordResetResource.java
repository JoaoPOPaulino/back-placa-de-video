package br.unitins.back.resource;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

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
    @Operation(summary = "Solicitar recuperação de senha", description = "Envia um e-mail com um link para redefinir a senha.")
    @APIResponse(responseCode = "200", description = "E-mail de recuperação enviado com sucesso")
    @APIResponse(responseCode = "404", description = "Usuário não encontrado")
    @APIResponse(responseCode = "500", description = "Erro interno ao enviar e-mail")
    public Response requestPasswordReset(@Parameter(description = "Login ou e-mail do usuário", required = true) @QueryParam("loginOrEmail") String loginOrEmail) {
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
    @Operation(summary = "Redefinir senha", description = "Redefine a senha do usuário usando o token recebido no e-mail.")
    @APIResponse(responseCode = "200", description = "Senha redefinida com sucesso")
    @APIResponse(responseCode = "400", description = "Token inválido ou expirado")
    public Response resetPassword(@Parameter(description = "Token de recuperação", required = true) @QueryParam("token") String token,@Parameter(description = "Nova senha do usuário", required = true) @QueryParam("newPassword") String newPassword) {
        try {
            passwordResetService.resetPassword(token, newPassword);
            return Response.ok("Senha redefinida com sucesso").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}

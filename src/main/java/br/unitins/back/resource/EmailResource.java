package br.unitins.back.resource;

import br.unitins.back.service.email.EmailService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/email")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmailResource {

    @Inject
    EmailService emailService;

    @POST
    public Response sendEmail() {
        emailService.sendEmail("joaopedrojpjp4@hotmail.com",
                "Teste de envio de email",
                "Este é um teste de envio de email utilizando o Quarkus.");
        return Response.ok("Enviado").build();
    }
}

package br.unitins.back.resource;

import br.unitins.back.dto.request.pagamento.GooglePayTokenDTO;
import br.unitins.back.dto.response.PagamentoResponseDTO;
import br.unitins.back.service.pagamento.PagamentoService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/pagamentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PagamentoResource {

    @Inject
    private PagamentoService pagamentoService;

    @GET
    @Path("/pedido/{id}")
    public Response findById(@PathParam("id") Long id) {
        try {
            PagamentoResponseDTO response = pagamentoService.findById(id);
            return Response.ok(response).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/googlepay/{idPedido}")
    public Response processarGooglePay(@PathParam("idPedido") Long idPedido, @Valid GooglePayTokenDTO dto) {
        try {
            PagamentoResponseDTO response = pagamentoService.processarPagamentoGooglePay(dto, idPedido);
            return Response.ok(response).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

}

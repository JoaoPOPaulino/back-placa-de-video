package br.unitins.back.resource;

import java.util.List;

import br.unitins.back.dto.request.pedido.PedidoDTO;
import br.unitins.back.dto.response.PedidoResponseDTO;
import br.unitins.back.service.pedido.PedidoService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {

    @Inject
    PedidoService pedidoService;

    @POST
    @Path("/usuario/{idUsuario}")
    public Response insert(@Valid PedidoDTO dto, @PathParam("idUsuario") Long idUsuario) {
        PedidoResponseDTO response = pedidoService.insert(dto, idUsuario);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @PUT
    @Path("/{idPedido}/status/{novoStatus}")
    public Response updateStatus(@PathParam("idPedido") Long idPedido,
            @PathParam("novoStatus") String novoStatus) {
        PedidoResponseDTO response = pedidoService.updateStatus(idPedido, novoStatus);
        return Response.ok(response).build();
    }

    @DELETE
    @Path("/{idPedido}")
    public Response delete(@PathParam("idPedido") Long idPedido) {
        pedidoService.delete(idPedido);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{idPedido}")
    public Response findById(@PathParam("idPedido") Long idPedido) {
        PedidoResponseDTO response = pedidoService.findById(idPedido);
        return Response.ok(response).build();
    }

    @GET
    @Path("/usuario/{idUsuario}")
    public Response findByUsuario(@PathParam("idUsuario") Long idUsuario) {
        List<PedidoResponseDTO> responses = pedidoService.findByUsuario(idUsuario);
        return Response.ok(responses).build();
    }

    @GET
    public Response findAll() {
        List<PedidoResponseDTO> responses = pedidoService.findAll();
        return Response.ok(responses).build();
    }
}

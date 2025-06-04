package br.unitins.back.resource;

import java.util.List;

import br.unitins.back.dto.request.AvaliacaoDTO;
import br.unitins.back.dto.response.AvaliacaoResponseDTO;
import br.unitins.back.service.avaliacao.AvaliacaoService;
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
import jakarta.ws.rs.core.Response.Status;

@Path("/avaliacoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AvaliacaoResource {

    @Inject
    AvaliacaoService avaliacaoService;

    @POST
    public Response create(@Valid AvaliacaoDTO dto) {
        AvaliacaoResponseDTO response = avaliacaoService.create(dto);
        return Response.status(Status.CREATED).entity(response).build();
    }

    @GET
    public Response findAll() {
        List<AvaliacaoResponseDTO> response = avaliacaoService.findAll();
        return Response.ok(response).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        AvaliacaoResponseDTO response = avaliacaoService.findById(id);
        return Response.ok(response).build();
    }

    @GET
    @Path("/placa/{idPlaca}")
    public Response findByPlacaDeVideo(@PathParam("idPlaca") Long idPlaca) {
        List<AvaliacaoResponseDTO> response = avaliacaoService.findByPlacaDeVideo(idPlaca);
        return Response.ok(response).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid AvaliacaoDTO dto) {
        AvaliacaoResponseDTO response = avaliacaoService.update(id, dto);
        return Response.ok(response).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        avaliacaoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}

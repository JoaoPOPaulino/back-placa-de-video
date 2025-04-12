package br.unitins.back.resource;

import java.util.List;

import br.unitins.back.dto.request.placa_de_video.PlacaDeVideoDTO;
import br.unitins.back.dto.response.PlacaDeVideoResponseDTO;
import br.unitins.back.model.placa_de_video.Categoria;
import br.unitins.back.service.placa_de_video.PlacaDeVideoService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/placas-de-video")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlacaDeVideoResource {

    @Inject
    PlacaDeVideoService service;

    @POST
    public Response create(@Valid PlacaDeVideoDTO dto) {
        return Response.status(Status.CREATED).entity(service.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid PlacaDeVideoDTO dto) {
        service.update(id, dto);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public PlacaDeVideoResponseDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @GET
    public List<PlacaDeVideoResponseDTO> findAll(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("8") int pageSize
    ) {
        return service.findAll(page, pageSize);
    }

    @GET
    @Path("/search")
    public List<PlacaDeVideoResponseDTO> findByNome(
            @QueryParam("nome") String nome,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("8") int pageSize
    ) {
        return service.findByNome(nome, page, pageSize);
    }

    @GET
    @Path("/search/categoria/{categoria}")
    public Response findByCategoria(@PathParam("categoria") Categoria categoria) {
        Response response = Response.ok(service.findByCategoria(categoria)).build();
        return response;
    }

    @GET
    @Path("/count")
    public long count() {
        return service.count();
    }

    @GET
    @Path("/search/count")
    public long countByNome(@QueryParam("nome") String nome) {
        return service.countByNome(nome);
    }
}

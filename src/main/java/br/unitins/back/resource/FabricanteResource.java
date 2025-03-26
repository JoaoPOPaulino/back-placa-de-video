package br.unitins.back.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.back.dto.request.placa_de_video.FabricanteDTO;
import br.unitins.back.dto.response.FabricanteResponseDTO;
import br.unitins.back.model.placa_de_video.Fabricante;
import br.unitins.back.service.fabricante.FabricanteService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
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

@Path("fabricantes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FabricanteResource {

    private static final Logger LOGGER = Logger.getLogger(FabricanteResource.class.getName());

    @Inject
    FabricanteService service;

    @GET
    public List<FabricanteResponseDTO> buscarTodos(@QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("page_size") @DefaultValue("100") int pageSize) {
        return service.findAll(page, pageSize).stream()
                .map(FabricanteResponseDTO::valueOf)
                .toList();

    }

    @GET
    @Path("/nome/{nome}")
    public List<Fabricante> buscarPorNome(@PathParam("nome") String nome, @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("page_size") @DefaultValue("100") int pageSize) {
        return service.findByNome(nome, page, pageSize);
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {

        LOGGER.info("Buscando fabricante com ID: " + id);
        Response response = Response.ok(service.findById(id)).build();
        LOGGER.info("Fabricante com ID: " + id + " recuperado com sucesso");
        return response;
    }

    @POST
    public Response insert(FabricanteDTO dto) {
        LOGGER.info("Iniciando inserção de um novo fabricante");
        Response response = Response.status(Status.CREATED).entity(service.create(dto)).build();
        LOGGER.info("Fabricante inserido com sucesso");
        return response;
    }

    @PUT
    @Path("/{id}")
    public Response alterar(@PathParam("id") Long id, FabricanteDTO dto) {
        LOGGER.info("Iniciando atualização do fabricante com ID: " + id);
        service.update(id, dto);
        LOGGER.info("Fabricante com ID: " + id + " atualizado com sucesso");
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        LOGGER.info("Iniciando remoção do fabricante com ID: " + id);
        service.delete(id);
        LOGGER.info("Fabricante com ID: " + id + " removido com sucesso");
        return Response.noContent().build();
    }

    @GET
    @Path("/count")
    public long total() {
        return service.count();
    }

    @GET
    @Path("/nome/{nome}/count")
    public long totalPorNome(String nome) {
        return service.count(nome);
    }

}

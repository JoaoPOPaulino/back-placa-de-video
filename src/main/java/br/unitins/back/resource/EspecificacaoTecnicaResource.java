package br.unitins.back.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.back.dto.request.placa_de_video.EspecificacaoTecnicaDTO;
import br.unitins.back.dto.response.EspecificacaoTecnicaResponseDTO;
import br.unitins.back.service.especificacao_tecnica.EspecificacaoTecnicaService;
import jakarta.inject.Inject;
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

@Path("/especificacoes-tecnicas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EspecificacaoTecnicaResource {

    private static final Logger LOGGER = Logger.getLogger(EspecificacaoTecnicaResource.class.getName());

    @Inject
    EspecificacaoTecnicaService service;

    @POST
    public Response create(EspecificacaoTecnicaDTO dto) {
        LOGGER.info("Iniciando inserção de uma nova especificação técnica");
        Response response = Response.status(Status.CREATED).entity(service.create(dto)).build();
        LOGGER.info("Especificação técnica inserida com sucesso");
        return response;
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, EspecificacaoTecnicaDTO dto) {
        LOGGER.info("Iniciando atualização da especificação técnica");
        service.update(id, dto);
        LOGGER.info("Especificação técnica com ID: " + id + " atualizada com sucesso");
        return Response.noContent().build();
    }

    @GET
    public List<EspecificacaoTecnicaResponseDTO> buscarTodos(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("100") int pageSize
    ) {
        return service.findAll(page, pageSize); // Remove o .stream().map() pois já é feito no service
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        LOGGER.info("Buscando especificação técnica com ID: " + id);
        Response response = Response.ok(service.findById(id)).build();
        LOGGER.info("Especificação técnica com ID: " + id + " recuperado com sucesso");
        return response;
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        LOGGER.info("Iniciando remoção da especificação técnica com ID: " + id);
        service.delete(id);
        LOGGER.info("Especificação técnica com ID: " + id + " removido com sucesso");
        return Response.noContent().build();
    }

    @GET
    @Path("/count")
    public long total() {
        return service.count();
    }
}

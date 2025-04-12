package br.unitins.back.resource;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.back.dto.request.placa_de_video.PlacaDeVideoDTO;
import br.unitins.back.dto.response.PlacaDeVideoResponseDTO;
import br.unitins.back.form.ImageForm;
import br.unitins.back.model.placa_de_video.Categoria;
import br.unitins.back.service.placa_de_video.PlacaDeVideoFileService;
import br.unitins.back.service.placa_de_video.PlacaDeVideoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

@Path("/placas-de-video")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlacaDeVideoResource {

    @Inject
    PlacaDeVideoService service;

    @Inject
    PlacaDeVideoFileService fileService;

    private static final Logger LOGGER = Logger.getLogger(PlacaDeVideoResource.class.getName());

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

    @PATCH
    @Path("/{id}/upload/imagem")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Transactional
    public Response salvarImagemPlaca(@PathParam("id") Long id, @MultipartForm ImageForm form) {
        LOGGER.info("Iniciando upload de imagem para a placa de vídeo com ID: " + id);
        try {
            // Corrigido: usando a instância injetada em vez de chamada estática
            String nomeImagem = fileService.salvar(form.getNomeImagem(), form.getImagem());
            PlacaDeVideoResponseDTO response = service.updateNomeImagem(id, nomeImagem);

            if (response == null) {
                LOGGER.warn("Placa com ID: " + id + " não encontrado.");
                return Response.status(Status.NOT_FOUND).entity("Imagem não encontrada").build();
            }
            LOGGER.info("Imagem atualizada com sucesso para a placa de vídeo com ID: " + id);
            return Response.ok(response).build();
        } catch (IOException e) {
            LOGGER.error("Erro ao salvar imagem: " + e.getMessage());
            return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/download/imagem/{nomeImagem}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("nomeImagem") String nomeImagem) {
        LOGGER.info("Iniciando download da imagem: " + nomeImagem);
        File file = fileService.obter(nomeImagem);
        if (file == null || !file.exists()) {
            LOGGER.warn("Imagem: " + nomeImagem + " não encontrada");
            return Response.status(Status.NOT_FOUND).entity("Imagem não encontrada.").build();
        }

        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment;filename=\"" + file.getName() + "\"");
        LOGGER.info("Download da imagem: " + nomeImagem + " realizado com sucesso");
        return response.build();
    }
}

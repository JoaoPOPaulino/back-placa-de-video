package br.unitins.back.resource;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.back.dto.request.usuario.UsuarioDTO;
import br.unitins.back.dto.response.UsuarioResponseDTO;
import br.unitins.back.form.ImageForm;
import br.unitins.back.service.usuario.UsuarioFileService;
import br.unitins.back.service.usuario.UsuarioService;
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

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    private static final Logger LOGGER = Logger.getLogger(UsuarioResource.class.getName());

    @Inject
    UsuarioService service;

    @Inject
    UsuarioFileService fileService;

    @POST
    public Response insert(UsuarioDTO dto) {
        LOGGER.info("Iniciando inserção de novo usuário");
        Response response = Response.status(Status.CREATED).entity(service.insert(dto)).build();
        LOGGER.info("Usuário inserido com sucesso");
        return response;
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(@Valid UsuarioDTO dto, @PathParam("id") Long id) {
        LOGGER.info("Iniciando atualização do usuário com ID: " + id);
        service.update(dto, id);
        LOGGER.info("Usuário com ID: " + id + " atualizado com sucesso");
        return Response.noContent().build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        LOGGER.info("Iniciando remoção do usuário com ID: " + id);
        service.delete(id);
        LOGGER.info("Usuário com ID: " + id + " removido com sucesso");
        return Response.noContent().build();
    }

    @GET
    public List<UsuarioResponseDTO> findAll(
            @QueryParam("page") @DefaultValue("0") Integer page,
            @QueryParam("pageSize") @DefaultValue("8") Integer pageSize) {
        return service.findAll(page, pageSize);
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        LOGGER.info("Buscando usuário com ID: " + id);
        Response response = Response.ok(service.findById(id)).build();
        LOGGER.info("Usuário com ID: " + id + " recuperado com sucesso");
        return response;
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        LOGGER.info("Buscando usuário pelo nome: " + nome);
        Response response = Response.ok(service.findByNome(nome)).build();
        LOGGER.info("Usuários com nome: " + nome + " recuperados com sucesso");
        return response;
    }

    @GET
    @Path("/count")
    public long count() {
        return service.count();
    }

    @GET
    @Path("/exists")
    @Produces(MediaType.APPLICATION_JSON)
    public Response verificarSeExisteLogin(@QueryParam("login") String login) {
        boolean existe = service.existsByLogin(login);
        return Response.ok(existe).build();
    }

    @PATCH
    @Path("/{id}/upload/imagem")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Transactional
    public Response salvarImagemUsuario(@PathParam("id") Long id, @MultipartForm ImageForm form) {
        LOGGER.info("Iniciando atualização do nome da imagem do usuário com ID: " + id);
        try {
            String nomeImagem = fileService.salvar(form.getNomeImagem(), form.getImagem());
            UsuarioResponseDTO response = service.updateNomeImagem(id, nomeImagem);

            if (response == null) {
                LOGGER.warn("Usuário com ID: " + id + " não encontrado.");
                return Response.status(Status.NOT_FOUND).entity("Imagem não encontrada").build();
            }
            LOGGER.info("Nome da imagem atualizado com sucesso para o usuário com ID: " + id);
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

package br.unitins.back.resource;

import org.jboss.logging.Logger;

import br.unitins.back.dto.request.usuario.UsuarioDTO;
import br.unitins.back.dto.response.UsuarioResponseDTO;
import br.unitins.back.service.usuario.UsuarioService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    private static final Logger LOGGER = Logger.getLogger(UsuarioResource.class.getName());

    @Inject
    UsuarioService service;

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
    public Response findAll() {
        LOGGER.info("Buscando todos os usuários");
        Response response = Response.ok(service.findAll()).build();
        LOGGER.info("Usuários recuperados com sucesso");
        return response;
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

    @POST
    @Path("/login")
    public Response login(@Valid UsuarioDTO dto) {
    try {
        UsuarioResponseDTO usuario = service.findByLoginOrEmailAndSenha(dto.login(), dto.senha());
        return Response.ok(usuario).build();
    } catch (NotFoundException e) {
        return Response.status(Status.UNAUTHORIZED).build();
    }
}

    @GET
    @Path("/count")
    public long count() {
        return service.count();
    }
    
    @GET
    @Path("/exists/{login}")
    public Response existsByLogin(@PathParam("login") String login) {
        try {
            boolean exists = service.existsByLogin(login);
            return Response.ok(exists).build();
        } catch (Exception e) {
            LOGGER.error("Erro ao verificar login", e);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}


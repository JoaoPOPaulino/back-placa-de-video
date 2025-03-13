package br.unitins.back.service.usuario;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.back.dto.request.usuario.UsuarioDTO;
import br.unitins.back.dto.response.UsuarioResponseDTO;
import br.unitins.back.model.usuario.Usuario;
import br.unitins.back.repository.UsuarioRepository;
import br.unitins.back.resource.UsuarioResource;
import br.unitins.back.service.hash.HashService;
import br.unitins.back.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    UsuarioRepository repository;

    @Inject
    HashService hashService;

    private static final Logger LOGGER = Logger.getLogger(UsuarioResource.class.getName());

    @Override
    @Transactional
    public UsuarioResponseDTO insert(@Valid UsuarioDTO dto) {
        if (repository.findByLogin(dto.login()) != null) {
            LOGGER.error("Tentativa de criar usuário com login existente: " + dto.login());
            throw new ValidationException("login", "Login já existe.");
        }
        Usuario novoUsuario = new Usuario(dto, hashService);
        repository.persist(novoUsuario);
        return UsuarioResponseDTO.valueOf(novoUsuario);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(@Valid UsuarioDTO dto, Long id) {
        LOGGER.info("Iniciando atualização do usuário com ID: " + id);
        Usuario usuario = repository.findById(id);
        if (usuario == null) {
            LOGGER.error("Usuário não encontrado para o ID: " + id);
            throw new NotFoundException("Usuário não encontrado");
        }
        Usuario usuarioExiste = repository.findByLogin(dto.login());
        if (usuarioExiste != null && !usuarioExiste.getId().equals(id)) {
            throw new ValidationException("login", "Login já existe.");
        }
        LOGGER.info("Usuário encontrado, atualizando...");
        usuario.atualizarComDTO(dto, hashService);
        repository.persist(usuario);
        LOGGER.info("Usuario atualizado com sucesso.");
        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    public void delete(Long id) {
        if (!repository.deleteById(id)) {
            throw new NotFoundException("Usuário não encontrado.");
        }
    }

    @Override
    public UsuarioResponseDTO findById(Long id) {
        Usuario usuario = repository.findById(id);
        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado.");
        }
        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    public List<UsuarioResponseDTO> findByNome(String nome) {
        List<Usuario> usuarios = repository.findByNome(nome);
        List<UsuarioResponseDTO> dtos = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            dtos.add(UsuarioResponseDTO.valueOf(usuario));
        }
        return dtos;
    }

    @Override
    public List<UsuarioResponseDTO> findByAll() {
        List<Usuario> usuarios = repository.listAll();
        List<UsuarioResponseDTO> dtos = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            dtos.add(UsuarioResponseDTO.valueOf(usuario));
        }
        return dtos;
    }

    @Override
    public UsuarioResponseDTO findByLoginAndSenha(String login, String senha) {
        Usuario usuario = repository.findByLoginAndSenha(login, senha);
        if (usuario == null) {
            throw new ValidationException("login", "Login ou senha inválido");
        }

        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    public UsuarioResponseDTO findByLogin(String login) {
        Usuario usuario = repository.findByLogin(login);
        if (usuario == null) {
            throw new ValidationException("login", "Login não encontrado");
        }
        return UsuarioResponseDTO.valueOf(usuario);
    }
}

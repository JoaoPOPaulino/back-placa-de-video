package br.unitins.back.service.usuario;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.back.dto.request.usuario.EnderecoDTO;
import br.unitins.back.dto.request.usuario.TelefoneDTO;
import br.unitins.back.dto.request.usuario.UsuarioDTO;
import br.unitins.back.dto.response.UsuarioResponseDTO;
import br.unitins.back.model.usuario.Endereco;
import br.unitins.back.model.usuario.Perfil;
import br.unitins.back.model.usuario.Telefone;
import br.unitins.back.model.usuario.Usuario;
import br.unitins.back.repository.UsuarioRepository;
import br.unitins.back.resource.UsuarioResource;
import br.unitins.back.service.PasswordResetService;
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

    @Inject
    PasswordResetService passwordResetService;

    private static final Logger LOGGER = Logger.getLogger(UsuarioResource.class.getName());

    @Override
    @Transactional
    public UsuarioResponseDTO insert(@Valid UsuarioDTO dto) {
        if (repository.existsByLogin((dto.login()))) {
            throw new IllegalArgumentException("Login já está em uso");
        }
        Usuario usuario = new Usuario();
        mapDtoToEntity(dto, usuario);
        repository.persist(usuario);
        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(@Valid UsuarioDTO dto, Long id) {
        Usuario usuario = repository.findById(id);
        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }
        mapDtoToEntity(dto, usuario);
        return UsuarioResponseDTO.valueOf(usuario);
    }

    private void mapDtoToEntity(UsuarioDTO dto, Usuario usuario) {
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setLogin(dto.login());
        usuario.setSenha(hashService.getHashSenha(dto.senha()));
        usuario.setPerfil(Perfil.valueOf(dto.perfil()));

        usuario.setTelefones(new ArrayList<>());
        usuario.setEnderecos(new ArrayList<>());
        if (dto.telefones() != null && !dto.telefones().isEmpty()) {
            for (TelefoneDTO telDto : dto.telefones()) {
                Telefone telefone = new Telefone(telDto);
                usuario.getTelefones().add(telefone);
            }
            if (dto.enderecos() != null && !dto.enderecos().isEmpty()) {
                for (EnderecoDTO endDto : dto.enderecos()) {
                    Endereco endereco = new Endereco(endDto);
                    usuario.getEnderecos().add(endereco);
                }
            }
        }
    }

    @Override
    @Transactional
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
    public List<UsuarioResponseDTO> findAll() {
        return repository.listAll().stream()
                .map(UsuarioResponseDTO::valueOf).toList();
    }

    @Override
    public UsuarioResponseDTO findByLoginAndSenha(String login, String senha) {
        Usuario usuario = repository.findByLoginAndSenha(login, senha);
        if (usuario == null) {
            throw new NotFoundException("Login ou senha inválidos");
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

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public boolean existsByLogin(String login) {
        return repository.existsByLogin(login);
    }

    @Override
    public UsuarioResponseDTO findByLoginOrEmailAndSenha(String loginOuEmail, String senha) {
        String hashSenha = hashService.getHashSenha(senha);

        Usuario usuario = repository.findByLoginAndSenha(loginOuEmail, hashSenha);

        if (usuario == null) {
            usuario = repository.findByEmailAndSenha(loginOuEmail, hashSenha);
        }

        if (usuario == null) {
            throw new NotFoundException("Login ou senha inválidos");
        }

        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    public UsuarioResponseDTO findByEmailAndSenha(String email, String senha) {
        String hashSenha = hashService.getHashSenha(senha);
        Usuario usuario = repository.findByEmailAndSenha(email, hashSenha);
        if (usuario == null) {
            throw new NotFoundException("Email ou senha inválidos");
        }
        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    @Transactional
    public void requestPasswordReset(String loginOrEmail) {
        if (loginOrEmail == null || loginOrEmail.isBlank()) {
            throw new IllegalArgumentException("Login ou e-mail não pode ser vazio");
        }
        passwordResetService.requestPasswordReset(loginOrEmail);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO updateNomeImagem(Long id, String nomeImagem) {
        Usuario usuario = repository.findById(id);
        usuario.setNomeImagem(nomeImagem);
        return UsuarioResponseDTO.valueOf(usuario);
    }

}

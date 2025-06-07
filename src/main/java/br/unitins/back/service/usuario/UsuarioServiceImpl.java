package br.unitins.back.service.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        if (repository.existsByLogin(dto.login())) {
            throw new IllegalArgumentException("Login já está em uso");
        }
        if (repository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("E-mail já está em uso");
        }
        if (repository.find("cpf", dto.cpf()).count() > 0) { // Valida CPF único
            throw new IllegalArgumentException("CPF já está em uso");
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

        // Verifica se o email foi alterado e se já existe
        if (!usuario.getEmail().equals(dto.email()) && repository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("E-mail já está em uso");
        }

        // Verifica se o CPF foi alterado e se já existe
        if (!usuario.getCpf().equals(dto.cpf()) && repository.find("cpf", dto.cpf()).count() > 0) {
            throw new IllegalArgumentException("CPF já está em uso");
        }

        // Atualiza apenas os campos básicos
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setLogin(dto.login());
        usuario.setCpf(dto.cpf());

        switch (dto.perfil()) {
            case 1:
                usuario.setPerfil(Perfil.USER);
                break;
            case 2:
                usuario.setPerfil(Perfil.ADMIN);
                break;
            default:
                throw new IllegalArgumentException("Perfil inválido: " + dto.perfil());
        }

        // Atualiza imagem se fornecida
        if (dto.nomeImagem() != null) {
            usuario.setNomeImagem(dto.nomeImagem());
        }

        return UsuarioResponseDTO.valueOf(usuario);
    }

    private void mapDtoToEntity(UsuarioDTO dto, Usuario usuario) {
        LOGGER.info("Mapeando DTO para entidade. DTO: " + dto);
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setLogin(dto.login());
        if (dto.senha() != null && !dto.senha().isBlank()) {
            usuario.setSenha(hashService.getHashSenha(dto.senha()));
        }
        usuario.setCpf(dto.cpf());

        switch (dto.perfil()) {
            case 1:
                usuario.setPerfil(Perfil.USER);
                break;
            case 2:
                usuario.setPerfil(Perfil.ADMIN);
                break;
            default:
                throw new IllegalArgumentException("Perfil inválido: " + dto.perfil());
        }

        usuario.setTelefones(new ArrayList<>());
        usuario.setEnderecos(new ArrayList<>());
        if (dto.telefones() != null && !dto.telefones().isEmpty()) {
            LOGGER.debug("Telefones recebidos: " + dto.telefones());
            for (TelefoneDTO telDto : dto.telefones()) {
                Telefone telefone = new Telefone(telDto);
                usuario.getTelefones().add(telefone);
            }
        }
        if (dto.enderecos() != null && !dto.enderecos().isEmpty()) {
            LOGGER.debug("Endereços recebidos: " + dto.enderecos());
            for (EnderecoDTO endDto : dto.enderecos()) {
                Endereco endereco = new Endereco(endDto);
                usuario.getEnderecos().add(endereco);
            }
        }
        usuario.setNomeImagem(dto.nomeImagem());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Usuario usuario = repository.findById(id);
        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado.");
        }

        usuario.getTelefones().clear();
        usuario.getEnderecos().clear();

        repository.persist(usuario);

        if (!repository.deleteById(id)) {
            throw new NotFoundException("Falha ao deletar usuário.");
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
        return repository.findByNome(nome).stream()
                .map(UsuarioResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public List<UsuarioResponseDTO> findAll(Integer page, Integer pageSize) {
        return repository.findAllOrdered()
                .page(page, pageSize)
                .list()
                .stream()
                .map(UsuarioResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO findByLoginAndSenha(String login, String senha) {
        Usuario usuario = repository.findByLoginAndSenha(login, hashService.getHashSenha(senha));
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
        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }
        usuario.setNomeImagem(nomeImagem);
        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    @Transactional
    public void updateSenha(Long id, String novaSenha) {
        Usuario usuario = repository.findById(id);
        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }
        usuario.setSenha(hashService.getHashSenha(novaSenha));
    }

    @Override
    public UsuarioResponseDTO findByEmail(String email) {
        Usuario usuario = repository.findByEmail(email);
        if (usuario == null) {
            throw new ValidationException("email", "Email não encontrado");
        }
        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO addTelefone(Long id, TelefoneDTO telefoneDTO) {
        LOGGER.infof("Adicionando telefone para usuário ID: %d, Telefone: %s", id, telefoneDTO);
        Usuario usuario = repository.findById(id);
        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }
        Telefone telefone = new Telefone(telefoneDTO);
        usuario.getTelefones().add(telefone);
        repository.persist(usuario);
        LOGGER.infof("Telefone adicionado com sucesso para usuário ID: %d", id);
        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO removeTelefone(Long id, Long telefoneId) {
        LOGGER.infof("Removendo telefone ID: %d do usuário ID: %d", telefoneId, id);
        Usuario usuario = repository.findById(id);
        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }
        boolean removed = usuario.getTelefones().removeIf(t -> t.getId().equals(telefoneId));
        if (!removed) {
            throw new NotFoundException("Telefone não encontrado");
        }
        repository.persist(usuario);
        LOGGER.infof("Telefone ID: %d removido com sucesso", telefoneId);
        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO addEndereco(Long id, EnderecoDTO enderecoDTO) {
        LOGGER.infof("Adicionando endereço para usuário ID: %d, Endereço: %s", id, enderecoDTO);
        Usuario usuario = repository.findById(id);
        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }
        Endereco endereco = new Endereco(enderecoDTO);
        usuario.getEnderecos().add(endereco);
        repository.persist(usuario);
        LOGGER.infof("Endereço adicionado com sucesso para usuário ID: %d", id);
        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO removeEndereco(Long id, Long enderecoId) {
        LOGGER.infof("Removendo endereço ID: %d do usuário ID: %d", enderecoId, id);
        Usuario usuario = repository.findById(id);
        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }
        boolean removed = usuario.getEnderecos().removeIf(e -> e.getId().equals(enderecoId));
        if (!removed) {
            throw new NotFoundException("Endereço não encontrado");
        }
        repository.persist(usuario);
        LOGGER.infof("Endereço ID: %d removido com sucesso", enderecoId);
        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    @Transactional
    public void changePassword(Long id, String currentPassword, String newPassword) {
        Usuario usuario = repository.findById(id);
        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }
        if (!hashService.getHashSenha(currentPassword).equals(usuario.getSenha())) {
            throw new IllegalArgumentException("Senha atual incorreta");
        }
        if (newPassword.length() < 6) {
            throw new IllegalArgumentException("Nova senha deve ter pelo menos 6 caracteres");
        }
        usuario.setSenha(hashService.getHashSenha(newPassword));
        repository.persist(usuario);
    }

    @Override
    public boolean validarSenha(Long id, String senha) {
        Usuario usuario = repository.findById(id);
        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }
        return hashService.getHashSenha(senha).equals(usuario.getSenha());
    }

}

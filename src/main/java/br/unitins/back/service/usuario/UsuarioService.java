package br.unitins.back.service.usuario;

import java.util.List;

import br.unitins.back.dto.request.usuario.UsuarioDTO;
import br.unitins.back.dto.response.UsuarioResponseDTO;
import jakarta.validation.Valid;

public interface UsuarioService {

    UsuarioResponseDTO insert(@Valid UsuarioDTO dto);

    UsuarioResponseDTO update(@Valid UsuarioDTO dto, Long id);

    void delete(Long id);

    UsuarioResponseDTO findById(Long id);

    List<UsuarioResponseDTO> findByNome(String nome);

    List<UsuarioResponseDTO> findAll(Integer page, Integer pageSize);

    UsuarioResponseDTO findByLoginAndSenha(String login, String senha);

    UsuarioResponseDTO findByEmailAndSenha(String email, String senha);

    UsuarioResponseDTO findByLogin(String login);

    UsuarioResponseDTO findByEmail(String email);

    UsuarioResponseDTO findByLoginOrEmailAndSenha(String loginOuEmail, String senha);

    long count();

    boolean existsByLogin(String login);

    void requestPasswordReset(String loginOrEmail);

    UsuarioResponseDTO updateNomeImagem(Long id, String nomeImagem);

}

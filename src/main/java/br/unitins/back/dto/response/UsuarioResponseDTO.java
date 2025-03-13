package br.unitins.back.dto.response;

import java.util.List;

import br.unitins.back.dto.request.usuario.EnderecoDTO;
import br.unitins.back.dto.request.usuario.TelefoneDTO;
import br.unitins.back.model.usuario.Perfil;
import br.unitins.back.model.usuario.Usuario;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        String login,
        Perfil perfil,
        List<TelefoneDTO> telefones,
        List<EnderecoDTO> enderecos) {

    public static UsuarioResponseDTO valueOf(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getLogin(),
                usuario.getPerfil(),
                usuario.getTelefones().stream().map(TelefoneDTO::valueOf).toList(),
                usuario.getEnderecos().stream().map(EnderecoDTO::valueOf).toList()
        );
    }
}

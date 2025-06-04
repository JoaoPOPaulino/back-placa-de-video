package br.unitins.back.dto.request.usuario;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioDTO(
        @NotBlank(message = "O nome não pode ser vazio.")
        String nome,
        @NotBlank(message = "O e-mail não pode ser vazio.")
        @Email(message = "E-mail inválido.")
        String email,
        @NotBlank(message = "O login não pode ser vazio.")
        @Size(min = 3, message = "O login deve ter pelo menos 3 caracteres")
        String login,
        @NotBlank(message = "A senha não pode ser vazia.")
        @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.")
        String senha,
        @NotBlank(message = "O perfil não pode ser vazio.")
        Integer perfil,
        List<TelefoneDTO> telefones,
        List<EnderecoDTO> enderecos,
        String nomeImagem) {

}

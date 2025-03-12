package br.unitins.back.dto.request.usuario;

import br.unitins.back.model.usuario.Endereco;
import jakarta.validation.constraints.NotEmpty;


public record EnderecoDTO(
        @NotEmpty(message = "O campo não pode ser vazio.") String cep,
        @NotEmpty(message = "O campo não pode ser vazio.") String estado,
        @NotEmpty(message = "O campo não pode ser vazio.") String cidade,
        @NotEmpty(message = "O campo não pode ser vazio.") String quadra,
        @NotEmpty(message = "O campo não pode ser vazio.") String rua,
        @NotEmpty(message = "O campo não pode ser vazio.") Integer numero) {
    public static EnderecoDTO valueOf(Endereco endereco) {
        return new EnderecoDTO(
                endereco.getCep(),
                endereco.getEstado(),
                endereco.getCidade(),
                endereco.getQuadra(),
                endereco.getRua(),
                endereco.getNumero());
    }

}
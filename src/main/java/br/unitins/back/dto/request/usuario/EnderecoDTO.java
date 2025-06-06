package br.unitins.back.dto.request.usuario;

import br.unitins.back.model.usuario.Endereco;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(
    @NotEmpty(message = "O CEP não pode ser vazio")
    @Pattern(regexp = "\\d{8}", message = "O CEP deve conter exatamente 8 dígitos")
    String cep,
    
    @NotEmpty(message = "O estado não pode ser vazio")
    @Pattern(regexp = "[A-Z]{2}", message = "O estado deve conter exatamente 2 letras maiúsculas")
    String estado,
    
    @NotEmpty(message = "A cidade não pode ser vazia")
    String cidade,
    
    String quadra,
    
    @NotEmpty(message = "A rua não pode ser vazia")
    String rua,
    
    @NotNull(message = "O número não pode ser nulo")
    Integer numero
) {
    public static EnderecoDTO valueOf(Endereco endereco) {
        return new EnderecoDTO(
            endereco.getCep(),
            endereco.getEstado(),
            endereco.getCidade(),
            endereco.getQuadra(),
            endereco.getRua(),
            endereco.getNumero()
        );
    }
}
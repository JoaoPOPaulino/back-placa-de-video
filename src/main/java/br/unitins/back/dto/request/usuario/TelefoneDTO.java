package br.unitins.back.dto.request.usuario;

import br.unitins.back.model.usuario.Telefone;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record TelefoneDTO(
    @NotEmpty(message = "O código de área não pode ser vazio")
    @Pattern(regexp = "\\d{2}", message = "O código de área deve conter exatamente 2 dígitos")
    String codigoArea,

    @NotEmpty(message = "O número não pode ser vazio")
    @Pattern(regexp = "\\d{8,9}", message = "O número deve conter 8 ou 9 dígitos")
    String numero) {
    public static TelefoneDTO valueOf(Telefone telefone) {
        return new TelefoneDTO(
                telefone.getCodigoArea(),
                telefone.getNumero());
    }
}

package br.unitins.back.dto.request.usuario;

import br.unitins.back.model.usuario.Telefone;
import jakarta.validation.constraints.NotEmpty;

public record TelefoneDTO(
       @NotEmpty (message = "O código de área não pode ser vazio") String codigoArea,
       @NotEmpty (message = "O número não pode ser vazio")String numero) {
    public static TelefoneDTO valueOf(Telefone telefone) {
        return new TelefoneDTO(
                telefone.getCodigoArea(),
                telefone.getNumero());
    }
}

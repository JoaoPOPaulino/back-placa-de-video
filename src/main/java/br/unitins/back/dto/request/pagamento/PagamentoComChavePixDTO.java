package br.unitins.back.dto.request.pagamento;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record PagamentoComChavePixDTO(
        @Valid
        PagamentoDTO payment,
        @NotBlank(message = "A chave Pix é obrigatória.")
        String chavePix) {

}

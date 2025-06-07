package br.unitins.back.dto.request.pagamento;

import jakarta.validation.constraints.NotBlank;

public record GooglePayTokenDTO(
        @NotBlank(message = "O token do Google Pay é obrigatório.")
        String token
        ) {

}

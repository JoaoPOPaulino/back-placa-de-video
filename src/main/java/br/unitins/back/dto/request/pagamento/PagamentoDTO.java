package br.unitins.back.dto.request.pagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public record PagamentoDTO(
        @NotNull(message = "A data do pagamento é obrigatória.")
        LocalDateTime dataPagamento,
        @NotNull(message = "O valor pago é obrigatório.")
        BigDecimal valorPago) {

}

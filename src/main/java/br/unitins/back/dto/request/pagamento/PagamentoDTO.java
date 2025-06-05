package br.unitins.back.dto.request.pagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.unitins.back.model.pagamento.StatusPagamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PagamentoDTO(
        @NotNull(message = "A data do pagamento é obrigatória.")
        LocalDateTime dataPagamento,
        @NotNull(message = "O valor pago é obrigatório.")
        BigDecimal valorPago,
        @NotNull(message = "O status do pagamento é obrigatório.")
        StatusPagamento status,
        @NotBlank(message = "O tipo de pagamento é obrigatório.")
        String tipoPagamento) {

}

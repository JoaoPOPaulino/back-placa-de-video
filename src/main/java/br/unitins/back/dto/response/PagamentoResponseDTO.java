package br.unitins.back.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.unitins.back.model.pagamento.Pagamento;
import br.unitins.back.model.pagamento.StatusPagamento;

public record PagamentoResponseDTO(
        Long id,
        LocalDateTime dataPagamento,
        BigDecimal valorPago,
        StatusPagamento status) {

    public static PagamentoResponseDTO valueOf(Pagamento pagamento) {
        return new PagamentoResponseDTO(
                pagamento.getId(),
                pagamento.getDataPagamento(),
                pagamento.getValorPago(),
                pagamento.getStatus()
        );
    }
}

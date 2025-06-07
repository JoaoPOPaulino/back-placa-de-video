package br.unitins.back.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.unitins.back.model.pagamento.Pagamento;
import br.unitins.back.model.pagamento.Pix;
import br.unitins.back.model.pagamento.StatusPagamento;

public record PagamentoResponseDTO(
        Long id,
        LocalDateTime dataPagamento,
        BigDecimal valorPago,
        StatusPagamento status,
        String chavePix,
        String qrCodeBase64 // ✅ novo campo
) {

    public static PagamentoResponseDTO valueOf(Pagamento pagamento) {
        String chavePix = null;
        String qrCodeBase64 = null;

        if (pagamento instanceof Pix pix) {
            chavePix = pix.getChavePix();
            qrCodeBase64 = pix.getQrCodeBase64(); // ✅ novo campo
        }

        return new PagamentoResponseDTO(
                pagamento.getId(),
                pagamento.getDataPagamento(),
                pagamento.getValorPago(),
                pagamento.getStatus(),
                chavePix,
                qrCodeBase64
        );
    }
}

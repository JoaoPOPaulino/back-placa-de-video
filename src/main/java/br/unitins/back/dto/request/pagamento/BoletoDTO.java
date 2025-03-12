package br.unitins.back.dto.request.pagamento;

import br.unitins.back.model.pagamento.Boleto;

public record BoletoDTO(Long id,
        String codigoBarras) {

    public static BoletoDTO valueOf(Boleto boleto) {
        return new BoletoDTO(
                boleto.getId(),
                boleto.getCodigoBarras()
        );
    }
}

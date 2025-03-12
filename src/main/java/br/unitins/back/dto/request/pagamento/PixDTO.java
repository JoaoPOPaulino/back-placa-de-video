package br.unitins.back.dto.request.pagamento;

import br.unitins.back.model.pagamento.Pix;

public record PixDTO(Long id,
        String chavePix) {

    public static PixDTO valueOf(Pix pix) {
        return new PixDTO(
                pix.getId(),
                pix.getChavePix()
        );
    }
}

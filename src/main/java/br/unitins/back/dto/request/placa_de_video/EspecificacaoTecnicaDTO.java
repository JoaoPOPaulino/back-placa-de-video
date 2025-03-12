package br.unitins.back.dto.request.placa_de_video;

import br.unitins.back.model.placa_de_video.EspecificacaoTecnica;

public record EspecificacaoTecnicaDTO(
        String memoria,
        String clock,
        String barramento,
        String consumoEnergia) {

    public static EspecificacaoTecnicaDTO valueOf(EspecificacaoTecnica especificacao) {
        return new EspecificacaoTecnicaDTO(
                especificacao.getMemoria(),
                especificacao.getClock(),
                especificacao.getBarramento(),
                especificacao.getConsumoEnergia()
        );
    }
}

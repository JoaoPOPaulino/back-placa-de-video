package br.unitins.back.dto.response;

import br.unitins.back.model.placa_de_video.EspecificacaoTecnica;

public record EspecificacaoTecnicaResponseDTO(
        Long id,
        String memoria,
        String clock,
        String barramento,
        String consumoEnergia) {

    public static EspecificacaoTecnicaResponseDTO valueOf(EspecificacaoTecnica especificacao) {
        return new EspecificacaoTecnicaResponseDTO(
                especificacao.getId(),
                especificacao.getMemoria(),
                especificacao.getClock(),
                especificacao.getBarramento(),
                especificacao.getConsumoEnergia()
        );
    }
}
package br.unitins.back.dto.response;

import java.math.BigDecimal;

import br.unitins.back.dto.request.placa_de_video.EspecificacaoTecnicaDTO;
import br.unitins.back.dto.request.placa_de_video.FabricanteDTO;
import br.unitins.back.model.placa_de_video.PlacaDeVideo;

public record PlacaDeVideoResponseDTO(
        Long id,
        String nome,
        BigDecimal preco,
        String nomeImagem,
        EspecificacaoTecnicaDTO especificacaoTecnica,
        FabricanteDTO fabricante,
        String categoria) {

    public static PlacaDeVideoResponseDTO valueOf(PlacaDeVideo placa) {
        return new PlacaDeVideoResponseDTO(
                placa.getId(),
                placa.getNome(),
                placa.getPreco(),
                placa.getNomeImagem(),
                EspecificacaoTecnicaDTO.valueOf(placa.getEspecificacaoTecnica()),
                FabricanteDTO.valueOf(placa.getFabricante()),
                placa.getCategoria().getLabel()
        );
    }

}

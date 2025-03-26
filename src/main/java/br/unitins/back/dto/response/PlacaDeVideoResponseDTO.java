package br.unitins.back.dto.response;

import java.math.BigDecimal;

import br.unitins.back.dto.request.placa_de_video.EspecificacaoTecnicaDTO;
import br.unitins.back.model.placa_de_video.Fabricante;
import br.unitins.back.model.placa_de_video.PlacaDeVideo;

public record PlacaDeVideoResponseDTO(
        Long id,
        String nome,
        BigDecimal preco,
        String nomeImagem,
        EspecificacaoTecnicaDTO especificacaoTecnica,
        Fabricante fabricante,
        String categoria,
        Integer estoque) {

    public static PlacaDeVideoResponseDTO valueOf(PlacaDeVideo placa) {
        return new PlacaDeVideoResponseDTO(
                placa.getId(),
                placa.getNome(),
                placa.getPreco(),
                placa.getNomeImagem(),
                EspecificacaoTecnicaDTO.valueOf(placa.getEspecificacaoTecnica()),
                placa.getFabricante(),
                placa.getCategoria().getLabel(),
                placa.getEstoque()
        );
    }

}

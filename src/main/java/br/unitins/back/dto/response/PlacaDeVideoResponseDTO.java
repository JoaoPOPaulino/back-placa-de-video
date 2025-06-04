package br.unitins.back.dto.response;

import java.math.BigDecimal;

import br.unitins.back.model.placa_de_video.PlacaDeVideo;

public record PlacaDeVideoResponseDTO(
        Long id,
        String nome,
        BigDecimal preco,
        String nomeImagem,
        FabricanteResponseDTO fabricante,
        String categoria,
        Integer estoque,
        EspecificacaoTecnicaResponseDTO especificacaoTecnica,
        String descricao) {

    public static PlacaDeVideoResponseDTO valueOf(PlacaDeVideo placa) {
        return new PlacaDeVideoResponseDTO(
                placa.getId(),
                placa.getNome(),
                placa.getPreco(),
                placa.getNomeImagem(),
                FabricanteResponseDTO.valueOf(placa.getFabricante()),
                placa.getCategoria().getLabel(),
                placa.getEstoque(),
                EspecificacaoTecnicaResponseDTO.valueOf(placa.getEspecificacaoTecnica()),
                placa.getDescricao()
        );
    }
}

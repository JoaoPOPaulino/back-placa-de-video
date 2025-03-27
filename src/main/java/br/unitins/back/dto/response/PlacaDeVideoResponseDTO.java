package br.unitins.back.dto.response;

import java.math.BigDecimal;

import br.unitins.back.model.placa_de_video.Categoria;
import br.unitins.back.model.placa_de_video.PlacaDeVideo;

public record PlacaDeVideoResponseDTO(
        Long id,
        String nome,
        BigDecimal preco,
        String nomeImagem,
        FabricanteResponseDTO fabricante,
        Categoria categoria,
        Integer estoque,
        EspecificacaoTecnicaResponseDTO especificacaoTecnica) {

    public static PlacaDeVideoResponseDTO valueOf(PlacaDeVideo placa) {
        return new PlacaDeVideoResponseDTO(
                placa.getId(),
                placa.getNome(),
                placa.getPreco(),
                placa.getNomeImagem(),
                FabricanteResponseDTO.valueOf(placa.getFabricante()),
                placa.getCategoria(),
                placa.getEstoque(),
                EspecificacaoTecnicaResponseDTO.valueOf(placa.getEspecificacaoTecnica())
        );
    }
}

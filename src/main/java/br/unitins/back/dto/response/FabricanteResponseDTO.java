package br.unitins.back.dto.response;

import br.unitins.back.model.placa_de_video.Fabricante;

public record FabricanteResponseDTO(
        Long id,
        String nome) {

    public static FabricanteResponseDTO valueOf(Fabricante fabricante) {
        return new FabricanteResponseDTO(
                fabricante.getId(),
                fabricante.getNome());
    }
}

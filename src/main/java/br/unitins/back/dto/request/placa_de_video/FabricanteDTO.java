package br.unitins.back.dto.request.placa_de_video;

import br.unitins.back.model.placa_de_video.Fabricante;

public record FabricanteDTO(String nome) {

    public static FabricanteDTO valueOf(Fabricante fabricante) {
        return new FabricanteDTO(fabricante.getNome());
    }

    public String getNome() {
        return nome;
    }
}

package br.unitins.back.dto.request.placa_de_video;

import jakarta.validation.constraints.NotNull;

public record FabricanteDTO(
        @NotNull(message = "O fabricante não pode ser nulo.")
        String nome) {

}

package br.unitins.back.dto.request.placa_de_video;

import jakarta.validation.constraints.NotBlank;

public record EspecificacaoTecnicaDTO(
        @NotBlank(message = "A memória não pode ser vazia.")
        String memoria,
        @NotBlank(message = "O clock não pode ser vazio.")
        String clock,
        @NotBlank(message = "O barramento não pode ser vazio.")
        String barramento,
        @NotBlank(message = "O consumo de energia não pode ser vazio.")
        String consumoEnergia) {

}

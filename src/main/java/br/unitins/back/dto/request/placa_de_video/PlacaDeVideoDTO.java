package br.unitins.back.dto.request.placa_de_video;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PlacaDeVideoDTO(
        @NotEmpty(message = "O nome não pode ser vazio.")
        String nome,
        @NotNull(message = "O preço não pode ser nulo.")
        BigDecimal preco,
        @NotEmpty(message = "O nome da imagem não pode ser vazio.")
        String nomeImagem,
        @NotNull(message = "A especificação técnica é obrigatória.")
        EspecificacaoTecnicaDTO especificacaoTecnica,
        @NotNull(message = "O fabricante é obrigatório.")
        FabricanteDTO fabricante,
        @NotNull(message = "A categoria é obrigatória.")
        Integer idCategoria) {

}

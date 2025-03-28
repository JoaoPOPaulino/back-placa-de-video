package br.unitins.back.dto.request.placa_de_video;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record PlacaDeVideoDTO(
        @NotBlank(message = "O nome não pode ser vazio.")
        String nome,
        @NotNull(message = "O preço não pode ser nulo.")
        @Positive(message = "O preço deve ser positivo.")
        BigDecimal preco,
        String nomeImagem,
        @NotNull(message = "O fabricante é obrigatório.")
        Long idFabricante,
        @NotNull(message = "A categoria é obrigatória.")
        Integer idCategoria,
        @PositiveOrZero(message = "O estoque não pode ser negativo.")
        Integer estoque,
        @NotNull(message = "A especificação técnica é obrigatória.")
        Long idEspecificacaoTecnica) {

}

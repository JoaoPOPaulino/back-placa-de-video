package br.unitins.back.dto.request.pedido;

import jakarta.validation.constraints.NotNull;

public record ItemPedidoDTO(
        @NotNull(message = "O ID da placa de vídeo é obrigatório.")
        Long idPlacaDeVideo,
        @NotNull(message = "A quantidade é obrigatória.")
        Integer quantidade) {

}

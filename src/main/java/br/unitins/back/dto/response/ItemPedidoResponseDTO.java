package br.unitins.back.dto.response;

import java.math.BigDecimal;

import br.unitins.back.model.pedido.ItemPedido;

public record ItemPedidoResponseDTO(
        Long id,
        PlacaDeVideoResponseDTO placaDeVideo,
        Integer quantidade,
        BigDecimal precoUnitario) {

    public static ItemPedidoResponseDTO valueOf(ItemPedido item) {
        return new ItemPedidoResponseDTO(
                item.getId(),
                PlacaDeVideoResponseDTO.valueOf(item.getPlacaDeVideo()),
                item.getQuantidade(),
                item.getPrecoUnitario()
        );
    }
}

package br.unitins.back.dto.request.pedido;

import java.util.List;

import jakarta.validation.constraints.NotNull;

public record PedidoDTO(
        @NotNull(message = "A lista de itens é obrigatória.")
        List<ItemPedidoDTO> itens) {

}

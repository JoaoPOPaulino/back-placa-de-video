package br.unitins.back.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.unitins.back.model.pedido.Pedido;

public record PedidoResponseDTO(
        Long id,
        UsuarioResponseDTO usuario,
        List<ItemPedidoResponseDTO> itens,
        String status,
        BigDecimal valorTotal,
        LocalDateTime dataPedido) {

    public static PedidoResponseDTO valueOf(Pedido pedido) {
        return new PedidoResponseDTO(
                pedido.getId(),
                UsuarioResponseDTO.valueOf(pedido.getUsuario()),
                pedido.getItens().stream().map(ItemPedidoResponseDTO::valueOf).toList(),
                pedido.getStatus().name(),
                pedido.getValorTotal(),
                pedido.getDataPedido());
    }
}

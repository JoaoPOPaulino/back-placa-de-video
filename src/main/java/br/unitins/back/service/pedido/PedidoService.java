package br.unitins.back.service.pedido;

import java.util.List;

import br.unitins.back.dto.request.pedido.PedidoDTO;
import br.unitins.back.dto.response.PedidoResponseDTO;
import jakarta.validation.Valid;

public interface PedidoService {

    PedidoResponseDTO insert(@Valid PedidoDTO dto, Long idUsuario);

    PedidoResponseDTO updateStatus(Long idPedido, String novoStatus);

    void delete(Long idPedido);

    PedidoResponseDTO findById(Long idPedido);

    List<PedidoResponseDTO> findByUsuario(Long idUsuario);

    List<PedidoResponseDTO> findAll();
}

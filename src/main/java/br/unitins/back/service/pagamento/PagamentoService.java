package br.unitins.back.service.pagamento;

import br.unitins.back.dto.request.pagamento.PagamentoDTO;
import br.unitins.back.dto.response.PagamentoResponseDTO;
import jakarta.validation.Valid;

public interface PagamentoService {

    PagamentoResponseDTO processarPagamento(@Valid PagamentoDTO dto, Long idPedido);

    PagamentoResponseDTO salvarPagamentoComChavePix(Long idPedido, @Valid PagamentoDTO dto, String chavePix);

    PagamentoResponseDTO findById(Long id);
}

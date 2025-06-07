package br.unitins.back.service.pagamento;

import br.unitins.back.dto.request.pagamento.GooglePayTokenDTO;
import br.unitins.back.dto.response.PagamentoResponseDTO;

public interface PagamentoService {

    PagamentoResponseDTO findById(Long id);

    PagamentoResponseDTO processarPagamentoGooglePay(GooglePayTokenDTO dto, Long idPedido);
}

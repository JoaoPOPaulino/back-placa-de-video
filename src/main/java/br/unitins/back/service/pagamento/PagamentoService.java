package br.unitins.back.service.pagamento;

import br.unitins.back.dto.request.pagamento.GooglePayTokenDTO;
import br.unitins.back.dto.request.pagamento.PixDTO;
import br.unitins.back.dto.response.PagamentoResponseDTO;

public interface PagamentoService {

    PagamentoResponseDTO findById(Long id);

    PagamentoResponseDTO processarPagamentoGooglePay(GooglePayTokenDTO dto, Long idPedido);

    PagamentoResponseDTO processarPagamentoPix(PixDTO dto); // ✅ Adicione essa linha
}
package br.unitins.back.service.pagamento;

import br.unitins.back.dto.request.pagamento.PagamentoDTO;
import br.unitins.back.dto.response.PagamentoResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;

@ApplicationScoped
public class PagamentoServiceImpl implements PagamentoService {

    @Override
    public PagamentoResponseDTO processarPagamento(@Valid PagamentoDTO dto, Long idPedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processarPagamento'");
    }

}

package br.unitins.back.service.pagamento;

import org.jboss.logging.Logger;

import br.unitins.back.dto.request.pagamento.GooglePayTokenDTO;
import br.unitins.back.dto.response.PagamentoResponseDTO;
import br.unitins.back.model.pagamento.Pagamento;
import br.unitins.back.model.pagamento.Pix;
import br.unitins.back.model.pagamento.StatusPagamento;
import br.unitins.back.model.pedido.Pedido;
import br.unitins.back.repository.PagamentoRepository;
import br.unitins.back.repository.PedidoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PagamentoServiceImpl implements PagamentoService {

    private static final Logger logger = Logger.getLogger(PagamentoServiceImpl.class);
    private static final String ABACATEPAY_URL = "https://api.abacatepay.com/pagamentos";
    private static final String ABACATEPAY_API_KEY = "abc_dev_baWuDuS3DhcZFD3EpdznEYkH";

    @Inject
    PagamentoRepository pagamentoRepository;

    @Inject
    PedidoRepository pedidoRepository;

    @Transactional
    public PagamentoResponseDTO processarPagamentoGooglePay(GooglePayTokenDTO tokenDTO, Long idPedido) {
        logger.infof("Processando pagamento com Google Pay para o pedido %d", idPedido);

        Pedido pedido = pedidoRepository.findById(idPedido);
        if (pedido == null) {
            throw new RuntimeException("Pedido não encontrado: " + idPedido);
        }

        // Simulando processamento com token recebido
        logger.info("Token do Google Pay recebido: " + tokenDTO.token());

        // Criação do pagamento simulado
        Pagamento pagamento = new Pix(); // Ou crie uma classe PagamentoGooglePay extendendo Pagamento, se quiser
        pagamento.setValorPago(pedido.getValorTotal());
        pagamento.setStatus(StatusPagamento.APROVADO);
        pagamento.setPedido(pedido);

        pagamentoRepository.persist(pagamento);

        return PagamentoResponseDTO.valueOf(pagamento);
    }

    @Override
    public PagamentoResponseDTO findById(Long id) {
        Pagamento pagamento = pagamentoRepository.findById(id);
        if (pagamento == null) {
            throw new RuntimeException("Pagamento não encontrado: " + id);
        }

        return PagamentoResponseDTO.valueOf(pagamento);
    }

}

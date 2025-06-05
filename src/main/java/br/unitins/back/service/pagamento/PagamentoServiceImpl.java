package br.unitins.back.service.pagamento;

import org.jboss.logging.Logger;

import br.unitins.back.dto.request.pagamento.PagamentoDTO;
import br.unitins.back.dto.response.PagamentoResponseDTO;
import br.unitins.back.model.pagamento.Pix;
import br.unitins.back.model.pedido.Pedido;
import br.unitins.back.repository.PagamentoRepository;
import br.unitins.back.repository.PedidoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class PagamentoServiceImpl implements PagamentoService {

    private static final Logger logger = Logger.getLogger(PagamentoServiceImpl.class);

    @Inject
    PagamentoRepository pagamentoRepository;

    @Inject
    PedidoRepository pedidoRepository;

    @Override
    @Transactional
    public PagamentoResponseDTO processarPagamento(@Valid PagamentoDTO dto, Long idPedido) {
        logger.infof("Iniciando processamento de pagamento para pedido %d", idPedido);

        Pedido pedido = pedidoRepository.findById(idPedido);
        if (pedido == null) {
            logger.errorf("Pedido não encontrado: %d", idPedido);
            throw new RuntimeException("Pedido não encontrado: " + idPedido);
        }

        if (!"PIX".equalsIgnoreCase(dto.tipoPagamento())) {
            logger.error("Tipo de pagamento não suportado: " + dto.tipoPagamento());
            throw new RuntimeException("Apenas pagamento via Pix é suportado.");
        }

        logger.error("Integração com AbacatePay deve ser feita no frontend");
        throw new RuntimeException("Use o endpoint /pagamentos/salvar para processar pagamentos Pix");
    }

    @Override
    @Transactional
    public PagamentoResponseDTO salvarPagamentoComChavePix(Long idPedido, @Valid PagamentoDTO dto, String chavePix) {
        logger.infof("Salvando pagamento com chave Pix para pedido %d", idPedido);

        Pedido pedido = pedidoRepository.findById(idPedido);
        if (pedido == null) {
            logger.errorf("Pedido não encontrado: %d", idPedido);
            throw new RuntimeException("Pedido não encontrado: " + idPedido);
        }

        if (!"PIX".equalsIgnoreCase(dto.tipoPagamento())) {
            logger.error("Tipo de pagamento não suportado: " + dto.tipoPagamento());
            throw new RuntimeException("Apenas pagamento via Pix é suportado.");
        }

        Pix pagamento = new Pix();
        pagamento.setDataPagamento(dto.dataPagamento());
        pagamento.setValorPago(dto.valorPago());
        pagamento.setStatus(dto.status());
        pagamento.setPedido(pedido);
        pagamento.setChavePix(chavePix);

        pagamentoRepository.persist(pagamento);
        logger.infof("Pagamento persistido com sucesso para o pedido %d", idPedido);
        return PagamentoResponseDTO.valueOf(pagamento);
    }

    @Override
    public PagamentoResponseDTO findById(Long id) {
        Pix pagamento = pagamentoRepository.find("pedido.id = ?1", id).firstResult();
        if (pagamento == null) {
            logger.errorf("Pagamento não encontrado para o pedido: %d", id);
            throw new RuntimeException("Pagamento não encontrado para o pedido: " + id);
        }
        return PagamentoResponseDTO.valueOf(pagamento);
    }
}

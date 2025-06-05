package br.unitins.back.service.pagamento;

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
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;

import org.jboss.logging.Logger;

@ApplicationScoped
public class PagamentoServiceImpl implements PagamentoService {

    private static final Logger logger = Logger.getLogger(PagamentoServiceImpl.class);
    private static final String ABACATEPAY_URL = "https://api.abacatepay.com/pagamentos";
    private static final String ABACATEPAY_API_KEY = "abc_dev_baWuDuS3DhcZFD3EpdznEYkH";

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

        // Chamar a API da AbacatePay
        Client client = ClientBuilder.newClient();
        try {
            Response response = client.target(ABACATEPAY_URL)
                    .request(MediaType.APPLICATION_JSON)
                    .header("Authorization", "Bearer " + ABACATEPAY_API_KEY)
                    .post(Entity.json(new AbacatePayRequest(dto.valorPago(), "Pagamento do pedido " + idPedido, "pix")));

            if (response.getStatus() != 200) {
                logger.error("Erro ao chamar AbacatePay: " + response.getStatus());
                throw new RuntimeException("Falha ao gerar chave Pix.");
            }

            AbacatePayResponse abacateResponse = response.readEntity(AbacatePayResponse.class);
            if (abacateResponse.pix() == null || abacateResponse.pix().qrCode() == null) {
                logger.error("Chave Pix não retornada pela AbacatePay.");
                throw new RuntimeException("Chave Pix não retornada pela AbacatePay.");
            }

            // Criar e persistir o pagamento Pix
            Pix pagamento = new Pix();
            pagamento.setDataPagamento(dto.dataPagamento());
            pagamento.setValorPago(dto.valorPago());
            pagamento.setStatus(dto.status());
            pagamento.setPedido(pedido);
            pagamento.setChavePix(abacateResponse.pix().qrCode());

            pagamentoRepository.persist(pagamento);
            logger.infof("Pagamento persistido com sucesso para o pedido %d", idPedido);
            return PagamentoResponseDTO.valueOf(pagamento);
        } finally {
            client.close();
        }
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

    // Classes auxiliares para a integração com AbacatePay
    private record AbacatePayRequest(BigDecimal valor, String descricao, String metodo) {}
    private record AbacatePayResponse(PixData pix) {}
    private record PixData(String qrCode) {}
}
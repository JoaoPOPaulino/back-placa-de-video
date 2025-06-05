package br.unitins.back.service.pedido;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.unitins.back.dto.request.pedido.PedidoDTO;
import br.unitins.back.dto.response.PedidoResponseDTO;
import br.unitins.back.model.pedido.ItemPedido;
import br.unitins.back.model.pedido.Pedido;
import br.unitins.back.model.pedido.StatusPedido;
import br.unitins.back.model.placa_de_video.PlacaDeVideo;
import br.unitins.back.model.usuario.Usuario;
import br.unitins.back.repository.PedidoRepository;
import br.unitins.back.repository.PlacaDeVideoRepository;
import br.unitins.back.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.jboss.logging.Logger;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    private static final Logger logger = Logger.getLogger(PedidoServiceImpl.class);

    @Inject
    PedidoRepository pedidoRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    PlacaDeVideoRepository placaDeVideoRepository;

    @Override
    @Transactional
    public PedidoResponseDTO insert(@Valid PedidoDTO dto, Long idUsuario) {
        logger.infof("Criando pedido para o usuário com ID: %d", idUsuario);

        // Verifica se o usuário existe
        Usuario usuario = usuarioRepository.findById(idUsuario);
        if (usuario == null) {
            logger.errorf("Usuário não encontrado: %d", idUsuario);
            throw new RuntimeException("Usuário não encontrado: " + idUsuario);
        }

        // Cria o pedido
        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
        pedido.setDataPedido(java.time.LocalDateTime.now());

        // Processa os itens do pedido
        List<ItemPedido> itens = dto.itens().stream().map(itemDto -> {
            PlacaDeVideo placa = placaDeVideoRepository.findById(itemDto.idPlacaDeVideo());
            if (placa == null) {
                logger.errorf("Placa de vídeo não encontrada: %d", itemDto.idPlacaDeVideo());
                throw new RuntimeException("Placa de vídeo não encontrada: " + itemDto.idPlacaDeVideo());
            }

            ItemPedido item = new ItemPedido();
            item.setPedido(pedido);
            item.setPlacaDeVideo(placa);
            item.setQuantidade(itemDto.quantidade());
            item.setPrecoUnitario(placa.getPreco());
            return item;
        }).collect(Collectors.toList());

        // Calcula o valor total
        BigDecimal valorTotal = itens.stream()
                .map(item -> item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        pedido.setValorTotal(valorTotal);
        pedido.setItens(itens);

        // Persiste o pedido
        pedidoRepository.persist(pedido);
        logger.infof("Pedido criado com sucesso para o usuário %d com ID do pedido: %d", idUsuario, pedido.getId());

        return PedidoResponseDTO.valueOf(pedido);
    }

    @Override
    @Transactional
    public PedidoResponseDTO updateStatus(Long idPedido, String novoStatus) {
        logger.infof("Atualizando status do pedido %d para %s", idPedido, novoStatus);

        Pedido pedido = pedidoRepository.findById(idPedido);
        if (pedido == null) {
            logger.errorf("Pedido não encontrado: %d", idPedido);
            throw new RuntimeException("Pedido não encontrado: " + idPedido);
        }

        try {
            StatusPedido status = StatusPedido.valueOf(novoStatus.toUpperCase());
            pedido.setStatus(status);
            pedidoRepository.persist(pedido);
            logger.infof("Status do pedido %d atualizado para %s", idPedido, novoStatus);
            return PedidoResponseDTO.valueOf(pedido);
        } catch (IllegalArgumentException e) {
            logger.errorf("Status inválido: %s", novoStatus);
            throw new RuntimeException("Status inválido: " + novoStatus);
        }
    }

    @Override
    @Transactional
    public void delete(Long idPedido) {
        logger.infof("Deletando pedido com ID: %d", idPedido);
        Pedido pedido = pedidoRepository.findById(idPedido);
        if (pedido == null) {
            logger.errorf("Pedido não encontrado: %d", idPedido);
            throw new RuntimeException("Pedido não encontrado: " + idPedido);
        }
        pedidoRepository.delete(pedido);
        logger.infof("Pedido %d deletado com sucesso", idPedido);
    }

    @Override
    public PedidoResponseDTO findById(Long idPedido) {
        logger.infof("Buscando pedido com ID: %d", idPedido);
        Pedido pedido = pedidoRepository.findById(idPedido);
        if (pedido == null) {
            logger.errorf("Pedido não encontrado: %d", idPedido);
            throw new RuntimeException("Pedido não encontrado: " + idPedido);
        }
        return PedidoResponseDTO.valueOf(pedido);
    }

    @Override
    public List<PedidoResponseDTO> findByUsuario(Long idUsuario) {
        logger.infof("Buscando pedidos do usuário: %d", idUsuario);
        List<Pedido> pedidos = pedidoRepository.find("usuario.id = ?1", idUsuario).list();
        return pedidos.stream().map(PedidoResponseDTO::valueOf).collect(Collectors.toList());
    }

    @Override
    public List<PedidoResponseDTO> findAll() {
        logger.info("Buscando todos os pedidos");
        List<Pedido> pedidos = pedidoRepository.listAll();
        return pedidos.stream().map(PedidoResponseDTO::valueOf).collect(Collectors.toList());
    }
}
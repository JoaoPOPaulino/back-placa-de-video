package br.unitins.back.service.avaliacao;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.back.dto.request.AvaliacaoDTO;
import br.unitins.back.dto.response.AvaliacaoResponseDTO;
import br.unitins.back.model.avaliacao.Avaliacao;
import br.unitins.back.model.avaliacao.Nota;
import br.unitins.back.model.placa_de_video.PlacaDeVideo;
import br.unitins.back.model.usuario.Usuario;
import br.unitins.back.repository.AvaliacaoRepository;
import br.unitins.back.repository.PlacaDeVideoRepository;
import br.unitins.back.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class AvaliacaoServiceImpl implements AvaliacaoService {

    @Inject
    AvaliacaoRepository avaliacaoRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    PlacaDeVideoRepository placaDeVideoRepository;

    @Override
    @Transactional
    public AvaliacaoResponseDTO create(AvaliacaoDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.idUsuario());
        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }

        PlacaDeVideo placaDeVideo = placaDeVideoRepository.findById(dto.idPlacaDeVideo());
        if (placaDeVideo == null) {
            throw new NotFoundException("Placa de vídeo não encontrada");
        }

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setUsuario(usuario);
        avaliacao.setPlacaDeVideo(placaDeVideo);
        avaliacao.setComentario(dto.comentario());
        if (dto.nota() != null) {
            avaliacao.setNota(Nota.fromValor(dto.nota()));
        }

        avaliacaoRepository.persist(avaliacao);
        return AvaliacaoResponseDTO.valueOf(avaliacao);
    }

    @Override
    public AvaliacaoResponseDTO findById(Long id) {
        Avaliacao avaliacao = avaliacaoRepository.findById(id);
        if (avaliacao == null) {
            throw new NotFoundException("Avaliação não encontrada");
        }
        return AvaliacaoResponseDTO.valueOf(avaliacao);
    }

    @Override
    public List<AvaliacaoResponseDTO> findAll(Integer page, Integer pageSize) {
        return avaliacaoRepository.findAllOrdered()
                .page(page, pageSize)
                .list()
                .stream()
                .map(AvaliacaoResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public List<AvaliacaoResponseDTO> findByPlacaDeVideo(Long idPlacaDeVideo) {
        return avaliacaoRepository.findByPlacaDeVideo(idPlacaDeVideo)
                .stream()
                .map(AvaliacaoResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AvaliacaoResponseDTO update(Long id, AvaliacaoDTO dto) {
        Avaliacao avaliacao = avaliacaoRepository.findById(id);
        if (avaliacao == null) {
            throw new NotFoundException("Avaliação não encontrada");
        }

        Usuario usuario = usuarioRepository.findById(dto.idUsuario());
        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }

        PlacaDeVideo placaDeVideo = placaDeVideoRepository.findById(dto.idPlacaDeVideo());
        if (placaDeVideo == null) {
            throw new NotFoundException("Placa de vídeo não encontrada");
        }

        avaliacao.setUsuario(usuario);
        avaliacao.setPlacaDeVideo(placaDeVideo);
        avaliacao.setComentario(dto.comentario());
        if (dto.nota() != null) {
            avaliacao.setNota(Nota.fromValor(dto.nota()));
        } else {
            avaliacao.setNota(null);
        }

        avaliacaoRepository.persist(avaliacao);
        return AvaliacaoResponseDTO.valueOf(avaliacao);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Avaliacao avaliacao = avaliacaoRepository.findById(id);
        if (avaliacao == null) {
            throw new NotFoundException("Avaliação não encontrada");
        }
        avaliacaoRepository.delete(avaliacao);
    }

    @Override
    public long count() {
        return avaliacaoRepository.count();
    }

}

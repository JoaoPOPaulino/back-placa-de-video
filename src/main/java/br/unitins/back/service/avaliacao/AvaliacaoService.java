package br.unitins.back.service.avaliacao;

import java.util.List;

import br.unitins.back.dto.request.AvaliacaoDTO;
import br.unitins.back.dto.response.AvaliacaoResponseDTO;

public interface AvaliacaoService {

    AvaliacaoResponseDTO create(AvaliacaoDTO dto);

    AvaliacaoResponseDTO findById(Long id);

    List<AvaliacaoResponseDTO> findAll();

    List<AvaliacaoResponseDTO> findByPlacaDeVideo(Long idPlacaDeVideo);

    AvaliacaoResponseDTO update(Long id, AvaliacaoDTO dto);

    void delete(Long id);
}

package br.unitins.back.service.placa_de_video;

import java.util.List;

import br.unitins.back.dto.request.placa_de_video.PlacaDeVideoDTO;
import br.unitins.back.dto.response.PlacaDeVideoResponseDTO;
import br.unitins.back.model.placa_de_video.Categoria;
import jakarta.validation.Valid;

public interface PlacaDeVideoService {

    PlacaDeVideoResponseDTO insert(@Valid PlacaDeVideoDTO dto);

    PlacaDeVideoResponseDTO update(@Valid PlacaDeVideoDTO dto, Long id);

    void delete(Long id);

    PlacaDeVideoResponseDTO findById(Long id);

    List<PlacaDeVideoResponseDTO> findAll();

    List<PlacaDeVideoResponseDTO> findByCategoria(Categoria categoria);

    PlacaDeVideoResponseDTO updateNomeImagem(Long id, String nomeImagem);
}

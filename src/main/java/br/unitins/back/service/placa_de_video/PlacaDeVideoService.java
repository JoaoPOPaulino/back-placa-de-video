package br.unitins.back.service.placa_de_video;

import java.util.List;

import br.unitins.back.dto.request.placa_de_video.PlacaDeVideoDTO;
import br.unitins.back.dto.response.PlacaDeVideoResponseDTO;
import br.unitins.back.model.placa_de_video.Categoria;

public interface PlacaDeVideoService {

    PlacaDeVideoResponseDTO create(PlacaDeVideoDTO dto);

    PlacaDeVideoResponseDTO update(Long id, PlacaDeVideoDTO dto);

    void delete(Long id);

    PlacaDeVideoResponseDTO findById(Long id);

    List<PlacaDeVideoResponseDTO> findAll(int page, int pageSize);

    List<PlacaDeVideoResponseDTO> findByNome(String nome, int page, int pageSize);

    List<PlacaDeVideoResponseDTO> findByCategoria(Categoria categoria);

    long count();

    long countByNome(String nome);
}

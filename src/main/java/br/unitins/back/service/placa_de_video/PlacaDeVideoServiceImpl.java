package br.unitins.back.service.placa_de_video;

import java.util.List;

import br.unitins.back.dto.request.placa_de_video.PlacaDeVideoDTO;
import br.unitins.back.dto.response.PlacaDeVideoResponseDTO;
import br.unitins.back.model.placa_de_video.Categoria;
import br.unitins.back.repository.PlacaDeVideoRepository;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

public class PlacaDeVideoServiceImpl implements PlacaDeVideoService {

    @Inject
    PlacaDeVideoRepository repository;

    @Override
    public PlacaDeVideoResponseDTO insert(@Valid PlacaDeVideoDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public PlacaDeVideoResponseDTO update(@Valid PlacaDeVideoDTO dto, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public PlacaDeVideoResponseDTO findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<PlacaDeVideoResponseDTO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<PlacaDeVideoResponseDTO> findByCategoria(Categoria categoria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCategoria'");
    }

    @Override
    public PlacaDeVideoResponseDTO updateNomeImagem(Long id, String nomeImagem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateNomeImagem'");
    }

}

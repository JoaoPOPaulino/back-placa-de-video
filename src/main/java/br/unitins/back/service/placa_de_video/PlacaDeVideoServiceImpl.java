package br.unitins.back.service.placa_de_video;

import br.unitins.back.dto.request.placa_de_video.PlacaDeVideoDTO;
import br.unitins.back.dto.response.PlacaDeVideoResponseDTO;
import br.unitins.back.model.placa_de_video.*;
import br.unitins.back.repository.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PlacaDeVideoServiceImpl implements PlacaDeVideoService {

    @Inject
    PlacaDeVideoRepository repository;

    @Inject
    FabricanteRepository fabricanteRepository;

    @Override
    @Transactional
    public PlacaDeVideoResponseDTO create(PlacaDeVideoDTO dto) {
        PlacaDeVideo placa = new PlacaDeVideo();
        mapDtoToEntity(dto, placa);
        repository.persist(placa);
        return PlacaDeVideoResponseDTO.valueOf(placa);
    }

    @Override
    @Transactional
    public PlacaDeVideoResponseDTO update(Long id, PlacaDeVideoDTO dto) {
        PlacaDeVideo placa = repository.findById(id);
        if (placa == null) {
            throw new NotFoundException("Placa de vídeo não encontrada");
        }
        mapDtoToEntity(dto, placa);
        return PlacaDeVideoResponseDTO.valueOf(placa);
    }

    private void mapDtoToEntity(PlacaDeVideoDTO dto, PlacaDeVideo placa) {
        placa.setNome(dto.nome());
        placa.setPreco(dto.preco());
        placa.setNomeImagem(dto.nomeImagem());
        placa.setFabricante(fabricanteRepository.findById(dto.idFabricante()));
        placa.setCategoria(Categoria.valueOf(dto.idCategoria()));
        placa.setEstoque(dto.estoque());
        placa.setEspecificacaoTecnica(new EspecificacaoTecnica(dto.especificacaoTecnica()));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public PlacaDeVideoResponseDTO findById(Long id) {
        PlacaDeVideo placa = repository.findById(id);
        if (placa == null) {
            throw new NotFoundException("Placa de vídeo não encontrada");
        }
        return PlacaDeVideoResponseDTO.valueOf(placa);
    }

    @Override
    public List<PlacaDeVideoResponseDTO> findAll(int page, int pageSize) {
        return repository.findAll()
                .page(page, pageSize)
                .list()
                .stream()
                .map(PlacaDeVideoResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public List<PlacaDeVideoResponseDTO> findByNome(String nome, int page, int pageSize) {
        return repository.findByNome(nome, page, pageSize)
                .stream()
                .map(PlacaDeVideoResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public long countByNome(String nome) {
        return repository.count("nome LIKE ?1", "%" + nome + "%");
    }

    @Override
    public List<PlacaDeVideoResponseDTO> findByCategoria(Categoria categoria) {
        List<PlacaDeVideo> placas = repository.findByCategoria(categoria);
        return placas.stream()
                .map(PlacaDeVideoResponseDTO::valueOf)
                .collect(Collectors.toList());
    }
}

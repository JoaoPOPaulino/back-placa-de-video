package br.unitins.back.service.placa_de_video;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.back.dto.request.placa_de_video.PlacaDeVideoDTO;
import br.unitins.back.dto.response.PlacaDeVideoResponseDTO;
import br.unitins.back.model.placa_de_video.Categoria;
import br.unitins.back.model.placa_de_video.EspecificacaoTecnica;
import br.unitins.back.model.placa_de_video.PlacaDeVideo;
import br.unitins.back.repository.EspecificacaoTecnicaRepository;
import br.unitins.back.repository.FabricanteRepository;
import br.unitins.back.repository.PlacaDeVideoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PlacaDeVideoServiceImpl implements PlacaDeVideoService {

    @Inject
    PlacaDeVideoRepository repository;

    @Inject
    FabricanteRepository fabricanteRepository;

    @Inject
    EspecificacaoTecnicaRepository especificacaoRepository;

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
            System.out.println("ID recebido para atualização: " + id);
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

        EspecificacaoTecnica especificacao = especificacaoRepository.findById(dto.idEspecificacaoTecnica());
        if (especificacao == null) {
            throw new NotFoundException("Especificação técnica não encontrada");
        }
        placa.setEspecificacaoTecnica(especificacao);
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
        return repository.findAllOrdered()
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

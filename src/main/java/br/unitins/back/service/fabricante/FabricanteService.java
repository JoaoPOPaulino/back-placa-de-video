package br.unitins.back.service.fabricante;

import java.util.List;

import br.unitins.back.dto.request.placa_de_video.FabricanteDTO;
import br.unitins.back.dto.response.FabricanteResponseDTO;
import br.unitins.back.model.placa_de_video.Fabricante;

public interface FabricanteService {

    FabricanteResponseDTO create(FabricanteDTO fabricante);

    FabricanteResponseDTO update(long id, FabricanteDTO dto);

    void delete(long id);

    FabricanteResponseDTO findById(long id);

    List<Fabricante> findAll(Integer page, Integer pageSize);

    List<Fabricante> findByNome(String nome, Integer page, Integer pageSize);

    long count();

    long count(String nome);

}

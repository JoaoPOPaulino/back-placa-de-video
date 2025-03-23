package br.unitins.back.service.fabricante;

import java.util.List;

import br.unitins.back.dto.request.placa_de_video.FabricanteDTO;
import br.unitins.back.model.placa_de_video.Fabricante;

public interface FabricanteService {

    Fabricante create(FabricanteDTO fabricante);

    void update(long id, Fabricante fabricante);

    void delete(long id);

    Fabricante findById(long id);

    List<Fabricante> findAll(Integer page, Integer pageSize);

    List<Fabricante> findByNome(String nome, Integer page, Integer pageSize);
    long count();
    long count(String nome);

}

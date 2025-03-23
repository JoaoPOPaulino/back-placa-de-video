package br.unitins.back.service.fabricante;

import java.util.List;

import br.unitins.back.dto.request.placa_de_video.FabricanteDTO;
import br.unitins.back.model.placa_de_video.Fabricante;
import br.unitins.back.repository.FabricanteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class FabricanteServiceImpl implements FabricanteService {

    @Inject
    FabricanteRepository fabricanteRepository;

    @Override
    @Transactional
    public Fabricante create(FabricanteDTO fabricante) {
        Fabricante novoFabricante = new Fabricante();
        novoFabricante.setNome(fabricante.getNome());

        fabricanteRepository.persist(novoFabricante);

        return novoFabricante;
    }

    @Override
    @Transactional
    public void update(long id, Fabricante fabricante) {
        Fabricante edicaoFabricante = fabricanteRepository.findById(id);

        edicaoFabricante.setNome(fabricante.getNome());
    }

    @Override
    @Transactional
    public void delete(long id) {
        fabricanteRepository.deleteById(id);
    }

    @Override
    public Fabricante findById(long id) {
        return fabricanteRepository.findById(id);
    }

    @Override
    public List<Fabricante> findAll(Integer page, Integer pageSize) {
        return fabricanteRepository.findAll().page(page, pageSize).list();
    }

    @Override
    public List<Fabricante> findByNome(String nome, Integer page, Integer pageSize) {
        return fabricanteRepository.findByNome(nome).page(page, pageSize).list();
    }

    public List<Fabricante> findByNome(String nome) {
        return fabricanteRepository.findByNome(nome).list();
    }

    @Override
    public long count() {
        return fabricanteRepository.count();
    }

    @Override
    public long count(String nome) {
        return fabricanteRepository.findByNome(nome).count();
    }

}

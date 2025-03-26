package br.unitins.back.service.fabricante;

import java.util.List;

import br.unitins.back.dto.request.placa_de_video.FabricanteDTO;
import br.unitins.back.dto.response.FabricanteResponseDTO;
import br.unitins.back.model.placa_de_video.Fabricante;
import br.unitins.back.repository.FabricanteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class FabricanteServiceImpl implements FabricanteService {

    @Inject
    FabricanteRepository fabricanteRepository;

    @Override
    @Transactional
    public FabricanteResponseDTO create(FabricanteDTO dto) {
        Fabricante novoFabricante = new Fabricante(dto);
        fabricanteRepository.persist(novoFabricante);
        return FabricanteResponseDTO.valueOf(novoFabricante);
    }

    @Override
    @Transactional
    public FabricanteResponseDTO update(long id, FabricanteDTO dto) {
        Fabricante fabricante = fabricanteRepository.findById(id);
        if (fabricante == null) {
            throw new NotFoundException("Fabricante não encontrado.");
        }
        fabricante.atualizarFabricante(dto);
        return FabricanteResponseDTO.valueOf(fabricante);
    }

    @Override
    @Transactional
    public void delete(long id) {
        fabricanteRepository.deleteById(id);
    }

    @Override
    public FabricanteResponseDTO findById(long id) {
        Fabricante fabricante = fabricanteRepository.findById(id);
        if (fabricante == null) {
            throw new NotFoundException("Fabricante não encontrado.");
        }
        return FabricanteResponseDTO.valueOf(fabricante);
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

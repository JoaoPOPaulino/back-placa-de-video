package br.unitins.back.service.especificacao_tecnica;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.back.dto.request.placa_de_video.EspecificacaoTecnicaDTO;
import br.unitins.back.dto.response.EspecificacaoTecnicaResponseDTO;
import br.unitins.back.model.placa_de_video.EspecificacaoTecnica;
import br.unitins.back.repository.EspecificacaoTecnicaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class EspecificacaoTecnicaServiceImpl implements EspecificacaoTecnicaService {

    @Inject
    EspecificacaoTecnicaRepository repository;

    @Override
    @Transactional
    public EspecificacaoTecnicaResponseDTO create(EspecificacaoTecnicaDTO dto) {
        EspecificacaoTecnica especificacao = new EspecificacaoTecnica();
        especificacao.setMemoria(dto.memoria());
        especificacao.setClock(dto.clock());
        especificacao.setBarramento(dto.barramento());
        especificacao.setConsumoEnergia(dto.consumoEnergia());
        repository.persist(especificacao);
        return EspecificacaoTecnicaResponseDTO.valueOf(especificacao);
    }

    @Override
    @Transactional
    public EspecificacaoTecnicaResponseDTO update(Long id, EspecificacaoTecnicaDTO dto) {
        EspecificacaoTecnica especificacao = repository.findById(id);
        if (especificacao == null) {
            throw new NotFoundException("Especificação técnica não encontrada.");
        }
        especificacao.setMemoria(dto.memoria());
        especificacao.setClock(dto.clock());
        especificacao.setBarramento(dto.barramento());
        especificacao.setConsumoEnergia(dto.consumoEnergia());
        return EspecificacaoTecnicaResponseDTO.valueOf(especificacao);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public EspecificacaoTecnicaResponseDTO findById(Long id) {
        EspecificacaoTecnica especificacao = repository.findById(id);
        if (especificacao == null) {
            throw new NotFoundException("Especificação técnica não encontrada.");
        }
        return EspecificacaoTecnicaResponseDTO.valueOf(especificacao);
    }

    @Override
    public List<EspecificacaoTecnicaResponseDTO> findAll(Integer page, Integer pageSize) {
        return repository.findAll()
                .page(page, pageSize)
                .list()
                .stream()
                .map(EspecificacaoTecnicaResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return repository.count();
    }

}

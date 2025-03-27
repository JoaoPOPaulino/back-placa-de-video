package br.unitins.back.service.especificacao_tecnica;

import java.util.List;

import br.unitins.back.dto.request.placa_de_video.EspecificacaoTecnicaDTO;
import br.unitins.back.dto.response.EspecificacaoTecnicaResponseDTO;

public interface EspecificacaoTecnicaService {

    EspecificacaoTecnicaResponseDTO create(EspecificacaoTecnicaDTO dto);

    EspecificacaoTecnicaResponseDTO update(Long id, EspecificacaoTecnicaDTO dto);

    void delete(Long id);

    EspecificacaoTecnicaResponseDTO findById(Long id);

    List<EspecificacaoTecnicaResponseDTO> findAll(Integer page, Integer pageSize);

    long count();

}

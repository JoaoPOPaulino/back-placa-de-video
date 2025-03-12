package br.unitins.back.dto.response;

import java.time.LocalDateTime;

import br.unitins.back.model.avaliacao.Avaliacao;
import br.unitins.back.model.avaliacao.Nota;

public record AvaliacaoResponseDTO(
        Long id,
        Long usuario,
        Long placaDeVideo,
        Nota nota,
        String comentario,
        LocalDateTime dataCriacao) {

    public AvaliacaoResponseDTO(Avaliacao avaliacao) {
        this(
                avaliacao.getId(),
                avaliacao.getUsuario().getId(),
                avaliacao.getPlacaDeVideo().getId(),
                avaliacao.getNota(),
                avaliacao.getComentario(),
                avaliacao.getDataCriacao()
        );
    }
}

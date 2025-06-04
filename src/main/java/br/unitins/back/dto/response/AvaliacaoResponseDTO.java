package br.unitins.back.dto.response;

import java.time.LocalDateTime;

import br.unitins.back.model.avaliacao.Avaliacao;

public record AvaliacaoResponseDTO(
        Long id,
        Long usuario,
        Long placaDeVideo,
        Integer valorNota,
        String comentario,
        LocalDateTime dataCriacao) {

    public static AvaliacaoResponseDTO valueOf(Avaliacao avaliacao) {
        return new AvaliacaoResponseDTO(
                avaliacao.getId(),
                avaliacao.getUsuario().getId(),
                avaliacao.getPlacaDeVideo().getId(),
                avaliacao.getNota() != null ? avaliacao.getNota().getId() : null,
                avaliacao.getComentario(),
                avaliacao.getDataCriacao()
        );
    }
}

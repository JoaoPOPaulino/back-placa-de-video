package br.unitins.back.dto.request;

import br.unitins.back.model.avaliacao.Avaliacao;
import br.unitins.back.model.avaliacao.Nota;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AvaliacaoDTO(
        @NotNull(message = "O ID do usuário não pode ser nulo.")
        Long usuarioId,
        @NotNull(message = "O ID da placa de vídeo não pode ser nulo.")
        Long placaDeVideoId,
        @NotNull(message = "A nota não pode ser nula.")
        @Min(1)
        @Max(5)
        Nota nota,
        @NotEmpty(message = "O comentário não pode ser vazio.")
        String comentario) {

    public static AvaliacaoDTO valueOf(Avaliacao avaliacao) {
        return new AvaliacaoDTO(
                avaliacao.getUsuario().getId(),
                avaliacao.getPlacaDeVideo().getId(),
                avaliacao.getNota(),
                avaliacao.getComentario()
        );
    }
}

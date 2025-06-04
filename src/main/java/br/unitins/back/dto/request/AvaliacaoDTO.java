package br.unitins.back.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AvaliacaoDTO(
        @NotNull(message = "O ID do usuário é obrigatório")
        Long idUsuario,
        @NotNull(message = "O ID da placa de vídeo é obrigatório")
        Long idPlacaDeVideo,
        Integer nota, // Integer para permitir null (opcional)

        @NotBlank(message = "O comentário é obrigatório")
        String comentario
        ) {

}

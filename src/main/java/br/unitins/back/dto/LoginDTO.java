package br.unitins.back.dto;

import jakarta.validation.constraints.NotEmpty;

public record LoginDTO(
        @NotEmpty(message = "O campo não pode ser nulo.")
        String login,
        @NotEmpty(message = "O campo não pode ser nulo.")
        String senha) {

}

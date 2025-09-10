package com.devjefiro.marketing_place.domain.model.DTO.colaborador;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record ColaboradoRequestDTO(
        @NotNull
        String nome,
        @NotNull
        @Email
        String email,
        @NotNull
        String telefone,
        String role,
        @NotNull
        String loja_id
) {
}

package com.devjefiro.marketing_place.domain.model.DTO;

import jakarta.validation.constraints.NotNull;

public record EnderecoRequestDTO(
        @NotNull
        String cep,
        String logradouro,
        String bairro,
        String cidade,
        String estado,
        String numero) {
}

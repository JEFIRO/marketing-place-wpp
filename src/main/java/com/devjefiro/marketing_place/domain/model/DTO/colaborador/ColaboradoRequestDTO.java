package com.devjefiro.marketing_place.domain.model.DTO.colaborador;

public record ColaboradoRequestDTO(
        String nome,
        String telefone,
        String role,
        String loja_id
) {
}

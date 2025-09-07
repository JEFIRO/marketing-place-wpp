package com.devjefiro.marketing_place.domain.model.DTO.colaborador;

import com.devjefiro.marketing_place.domain.model.Colaborado;
import com.devjefiro.marketing_place.domain.model.RoleEnum;

public record ColaboradoResponseDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        RoleEnum role,
        Long loja) {
    public ColaboradoResponseDTO(Colaborado colaborador) {
        this(
                colaborador.getId(),
                colaborador.getNome(),
                colaborador.getEmail(),
                colaborador.getTelefone(),
                colaborador.getRole(),
                colaborador.getLoja().getId());
    }
}

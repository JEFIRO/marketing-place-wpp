package com.devjefiro.marketing_place.domain.model.DTO;

import com.devjefiro.marketing_place.domain.model.RoleEnum;

public record ColaboradoRequestDTO(
        String nome,
        String telefone,
        RoleEnum role,
        LojaRequestDTO loja
) {
}

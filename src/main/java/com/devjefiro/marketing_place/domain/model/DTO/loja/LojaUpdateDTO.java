package com.devjefiro.marketing_place.domain.model.DTO.loja;

public record LojaUpdateDTO(
        Long id,
        String nome,
        String telefone,
        String instagram,
        boolean status
) {}

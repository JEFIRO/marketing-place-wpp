package com.devjefiro.marketing_place.domain.model.DTO;

public record LojaRequestDTO(
        String nome,
        EnderecoRequestDTO endereco
) {
}

package com.devjefiro.marketing_place.domain.model.DTO;

public record ProdutoLojaResquestDTO(
        ProdutoRequestDTO produto,
        LojaRequestDTO loja,
        int quantidade
) {
}

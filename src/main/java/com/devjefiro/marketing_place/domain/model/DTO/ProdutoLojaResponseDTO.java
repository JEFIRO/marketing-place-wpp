package com.devjefiro.marketing_place.domain.model.DTO;

import com.devjefiro.marketing_place.domain.model.ProdutoLoja;

public record ProdutoLojaResponseDTO(
        long loja,
        long produto,
        int quantidade
) {
    public ProdutoLojaResponseDTO(ProdutoLoja produto) {
        this(
                produto.getProduto().getId(),
                produto.getLoja().getId(),
                produto.getQuantidade()
        );
    }
}

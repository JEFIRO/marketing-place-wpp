package com.devjefiro.marketing_place.domain.model.DTO;

import com.devjefiro.marketing_place.domain.model.ProdutoLoja;

public record ProdutoLojaResponseDTO(
        long produto,
        long loja,
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

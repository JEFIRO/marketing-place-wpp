package com.devjefiro.marketing_place.domain.model.DTO.produto;

import com.devjefiro.marketing_place.domain.model.ProdutoLoja;

public record ProdutoLojaDetalhadoResponseDTO(Long loja_id, String lojaName, int quantidade) {
    public ProdutoLojaDetalhadoResponseDTO(ProdutoLoja loja) {
        this(loja.getLoja().getId(), loja.getLoja().getNome(), loja.getQuantidade());
    }
}

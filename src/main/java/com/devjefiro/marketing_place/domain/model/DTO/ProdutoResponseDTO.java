package com.devjefiro.marketing_place.domain.model.DTO;

import com.devjefiro.marketing_place.domain.model.Colaborado;
import com.devjefiro.marketing_place.domain.model.Produto;
import com.devjefiro.marketing_place.domain.model.ProdutoLoja;

import java.util.Set;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        String descricao,
        String urlImage,
        int quantidade,
        Double valor,
        String promocao,
        long addedBy,
        Set<ProdutoLojaResponseDTO> produtosEmLojas,
        boolean disponivelNaLoja
) {
    public ProdutoResponseDTO(Produto produto) {
        this(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getUrlImage(),
                produto.getQuantidade(),
                produto.getValor(),
                produto.getPromocao(),
                produto.getAddedBy().getId(),
                produto.getLojaResponseList(produto.getProdutosEmLojas()),
                produto.isDisponivelNaLoja()
        );
    }
}

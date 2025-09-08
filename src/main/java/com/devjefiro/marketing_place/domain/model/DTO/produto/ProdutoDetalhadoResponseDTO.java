package com.devjefiro.marketing_place.domain.model.DTO.produto;

import com.devjefiro.marketing_place.domain.model.ProdutoLoja;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDetalhadoResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String urlImage;
    private int quantidade;
    private double valor;
    private String promocao;
    private List<ProdutoLojaDetalhadoResponseDTO> produtosEmLojas;
    private boolean disponivelNaLoja;

    public ProdutoDetalhadoResponseDTO(ProdutoLoja produtoLoja) {
        var p = produtoLoja.getProduto();
        this.id = p.getId();
        this.nome = p.getNome();
        this.descricao = p.getDescricao();
        this.urlImage = p.getUrlImage();
        this.quantidade = p.getQuantidade();
        this.valor = p.getValor();
        this.promocao = p.getPromocao();
        this.produtosEmLojas = asList(p.getProdutosEmLojas());
        this.disponivelNaLoja = p.isDisponivelNaLoja();
    }

    private static List<ProdutoLojaDetalhadoResponseDTO> asList(Set<ProdutoLoja> produtoLoja) {
        return produtoLoja.stream().map(ProdutoLojaDetalhadoResponseDTO::new).toList();
    }
}

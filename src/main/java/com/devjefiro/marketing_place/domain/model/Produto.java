package com.devjefiro.marketing_place.domain.model;

import com.devjefiro.marketing_place.domain.model.DTO.ProdutoLojaResponseDTO;
import com.devjefiro.marketing_place.domain.model.DTO.produto.ProdutoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "produto")
@Getter
@Setter
@AllArgsConstructor

@EqualsAndHashCode(of = {"id"})
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    @Column(name = "imagem")
    private String urlImage;
    private int quantidade;
    @Column(name = "preco")
    private double valor;
    private String promocao;
    @ManyToOne
    @JoinColumn(name = "added_by")
    private Colaborado addedBy;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProdutoLoja> produtosEmLojas;
    @Column(name = "disponivel")
    private boolean disponivelNaLoja;

    public Produto(ProdutoRequestDTO requestDTO) {
        this.produtosEmLojas = new HashSet<>();
        this.nome = requestDTO.nome();
        this.urlImage = requestDTO.urlImage();
        this.quantidade = requestDTO.quantidade();
        this.valor = requestDTO.valor();
        this.disponivelNaLoja = true;
    }

    public Produto() {
        this.produtosEmLojas = new HashSet<>();
    }

    public Set<ProdutoLojaResponseDTO> getLojaResponseList(Set<ProdutoLoja> produtosEmLojas) {
        Set<ProdutoLojaResponseDTO> lojas = new HashSet<>();
        produtosEmLojas.forEach(p -> lojas.add(new ProdutoLojaResponseDTO(p)));
        return lojas;
    }


}

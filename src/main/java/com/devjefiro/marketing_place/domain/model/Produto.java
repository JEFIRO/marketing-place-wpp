package com.devjefiro.marketing_place.domain.model;

import com.devjefiro.marketing_place.domain.model.DTO.ProdutoRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String urlImage;
    private int quantidade;
    private Double valor;
    private String promocao;
    @ManyToOne
    @JoinColumn(name = "added_by")
    private Colaborado addedBy;

    @ManyToMany
    @JoinTable(
            name = "produto_loja",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "loja_id")
    )
    private List<Loja> lojas;
    private String disponivelNaLoja;

    public Produto(ProdutoRequestDTO requestDTO) {
        this.nome = requestDTO.nome();
        this.urlImage = requestDTO.urlImage();
        this.quantidade = requestDTO.quantidade();
        this.valor = requestDTO.valor();
        this.addedBy = new Colaborado(requestDTO.addedBy());
        this.disponivelNaLoja = disponivelNaLoja;
        this.lojas = requestDTO.lojas().stream().map(Loja::new).toList();
    }
}

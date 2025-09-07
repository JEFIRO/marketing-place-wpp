package com.devjefiro.marketing_place.domain.model;

import com.devjefiro.marketing_place.domain.model.DTO.ProdutoLojaResquestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produto_loja")
@IdClass(ProdutoLojaId.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"produto", "loja"})
public class ProdutoLoja {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_loja")
    private Loja loja;

    private int quantidade;

    public ProdutoLoja(ProdutoLojaResquestDTO requestDTO) {
        this.quantidade = requestDTO.quantidade();
    }
}

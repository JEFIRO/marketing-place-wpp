package com.devjefiro.marketing_place.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "colaborado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class ProdutoLoja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "id_loja")
    private Loja loja;
    private int quantidade;

}

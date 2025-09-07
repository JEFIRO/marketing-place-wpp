package com.devjefiro.marketing_place.domain.model;

import com.devjefiro.marketing_place.domain.model.DTO.LojaRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "loja")
public class Loja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToMany(mappedBy = "loja")
    private List<Colaborado> colaboradores;

    @OneToMany(mappedBy = "loja")
    private Set<ProdutoLoja> produtos;

    public Loja(LojaRequestDTO requestDTO) {
        this.nome = requestDTO.nome();
        this.endereco = new Endereco(requestDTO.endereco());
    }
}

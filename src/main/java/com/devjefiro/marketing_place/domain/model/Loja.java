package com.devjefiro.marketing_place.domain.model;

import com.devjefiro.marketing_place.domain.model.DTO.LojaRequestDTO;
import com.devjefiro.marketing_place.domain.model.DTO.LojaResponseDTO;
import com.devjefiro.marketing_place.domain.model.DTO.ProdutoLojaResquestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


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

    @ManyToMany(mappedBy = "lojas")
    private List<Produto> produtos;

    public Loja(LojaRequestDTO requestDTO) {
        this.nome = requestDTO.nome();
        this.endereco = new Endereco(requestDTO.endereco());
    }
    public Loja(ProdutoLojaResquestDTO requestDTO) {
        this.produtos.add(new Produto());
    }

}

package com.devjefiro.marketing_place.domain.model;

import com.devjefiro.marketing_place.domain.model.DTO.loja.LojaRequestDTO;
import com.devjefiro.marketing_place.domain.model.DTO.loja.LojaUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "loja")
public class Loja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String instagram;
    private String telefone;
    private String cnpj;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
    private LocalDateTime dataExclusao;
    private boolean status;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToMany(mappedBy = "loja", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Colaborado> colaboradores;

    @OneToMany(mappedBy = "loja")
    private Set<ProdutoLoja> produtos;

    public Loja(LojaRequestDTO requestDTO) {
        colaboradores = new ArrayList<>();
        produtos = new HashSet<>();
        this.nome = requestDTO.nome();
        this.telefone = requestDTO.telefone();
        this.cnpj = requestDTO.cnpj();
        this.endereco = new Endereco(requestDTO.endereco());
        this.status = true;
    }

    public Loja(LojaUpdateDTO requestDTO) {
        colaboradores = new ArrayList<>();
        produtos = new HashSet<>();

        this.nome = requestDTO.nome();
        this.instagram = requestDTO.instagram();
        this.telefone = requestDTO.telefone();
        this.status = requestDTO.status();
    }

    public Loja() {
        colaboradores = new ArrayList<>();
        produtos = new HashSet<>();
    }
}

package com.devjefiro.marketing_place.domain.model;

import com.devjefiro.marketing_place.domain.model.DTO.EnderecoRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "endereco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String numero;

    public Endereco(EnderecoRequestDTO requestDTO) {
        this.cep = requestDTO.cep();
        this.logradouro = requestDTO.logradouro();
        this.bairro = requestDTO.bairro();
        this.cidade = requestDTO.cidade();
        this.estado = requestDTO.estado();
    }
}

package com.devjefiro.marketing_place.domain.model;


import com.devjefiro.marketing_place.domain.model.DTO.ColaboradoRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "colaborado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Colaborado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @ManyToOne
    @JoinColumn(name = "id_loja")
    private Loja loja;

    public Colaborado(ColaboradoRequestDTO requestDTO) {
        this.nome = requestDTO.nome();
        this.telefone = requestDTO.telefone();
        this.role = requestDTO.role();
        this.loja = new Loja(requestDTO.loja());
    }
}





package com.devjefiro.marketing_place.domain.model.DTO.colaborador;

import com.devjefiro.marketing_place.domain.model.Colaborado;
import lombok.Data;

@Data
public class ColaboradorResumeDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    public ColaboradorResumeDTO(Colaborado colaborador) {
        this.id = colaborador.getId();
        this.nome = colaborador.getNome();
        this.email = colaborador.getEmail();
        this.telefone = colaborador.getTelefone();
    }
}

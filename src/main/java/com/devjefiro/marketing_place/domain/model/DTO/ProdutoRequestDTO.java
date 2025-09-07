package com.devjefiro.marketing_place.domain.model.DTO;

import com.devjefiro.marketing_place.domain.model.DTO.colaborador.ColaboradoRequestDTO;

import java.util.List;

public record ProdutoRequestDTO(
        String nome,
        String urlImage,
        int quantidade,
        Double valor,
        ColaboradoRequestDTO addedBy,
        List<ProdutoLojaResquestDTO> lojas,
        String disponivelNaLoja
) {
}

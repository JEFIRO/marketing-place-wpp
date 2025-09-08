package com.devjefiro.marketing_place.domain.model.DTO.produto;

import com.devjefiro.marketing_place.domain.model.DTO.ProdutoLojaResquestDTO;

import java.util.List;

public record ProdutoRequestDTO(
        String nome,
        String urlImage,
        int quantidade,
        double valor,
        long colaborador_id,
        List<ProdutoLojaResquestDTO> lojas,
        boolean disponivelNaLoja
) {
}

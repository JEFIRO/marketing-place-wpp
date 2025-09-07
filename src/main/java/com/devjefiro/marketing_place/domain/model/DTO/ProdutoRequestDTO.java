package com.devjefiro.marketing_place.domain.model.DTO;

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

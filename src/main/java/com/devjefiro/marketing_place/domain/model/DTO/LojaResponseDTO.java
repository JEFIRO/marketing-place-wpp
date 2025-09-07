package com.devjefiro.marketing_place.domain.model.DTO;

import com.devjefiro.marketing_place.domain.model.Colaborado;
import com.devjefiro.marketing_place.domain.model.Endereco;
import com.devjefiro.marketing_place.domain.model.Loja;
import com.devjefiro.marketing_place.domain.model.Produto;

import java.util.List;

public record LojaResponseDTO(
        Long id,
        String nome,
        String telefone,
        Endereco endereco,
        List<Colaborado> colaboradores,
        List<Produto> produtos
) {
    public LojaResponseDTO(Loja loja) {
        this(loja.getId(),
                loja.getNome(),
                loja.getTelefone(),
                loja.getEndereco(),
                loja.getColaboradores(),
                loja.getProdutos()
        );
    }
}

package com.devjefiro.marketing_place.domain.model.DTO.loja;

import com.devjefiro.marketing_place.domain.model.*;

import java.util.List;
import java.util.Set;

public record LojaResponseDTO(
        Long id,
        String nome,
        String telefone,
        Endereco endereco,
        List<Colaborado> colaboradores,
        Set<ProdutoLoja> produtos

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

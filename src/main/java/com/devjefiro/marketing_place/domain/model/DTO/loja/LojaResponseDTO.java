package com.devjefiro.marketing_place.domain.model.DTO.loja;

import com.devjefiro.marketing_place.domain.model.*;
import com.devjefiro.marketing_place.domain.model.DTO.colaborador.ColaboradorResumeDTO;
import com.devjefiro.marketing_place.domain.model.DTO.produto.ProdutoDetalhadoResponseDTO;

import java.util.List;
import java.util.Set;

public record LojaResponseDTO(
        Long id,
        String nome,
        String telefone,
        Endereco endereco,
        List<ColaboradorResumeDTO> colaboradores,
        List<ProdutoDetalhadoResponseDTO> produtos

) {
    public LojaResponseDTO(Loja loja) {
        this(loja.getId(),
                loja.getNome(),
                loja.getTelefone(),
                loja.getEndereco(),
                loja.getColaboradores()
                        .stream()
                        .map(ColaboradorResumeDTO::new)
                        .toList(),
                loja.getProdutos()
                        .stream()
                        .map(ProdutoDetalhadoResponseDTO::new)
                        .toList()
        );
    }
}

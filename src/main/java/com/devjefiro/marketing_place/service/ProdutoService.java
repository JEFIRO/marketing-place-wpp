package com.devjefiro.marketing_place.service;

import com.devjefiro.marketing_place.domain.model.DTO.ProdutoLojaResquestDTO;
import com.devjefiro.marketing_place.domain.model.DTO.produto.ProdutoRequestDTO;
import com.devjefiro.marketing_place.domain.model.DTO.produto.ProdutoResponseDTO;
import com.devjefiro.marketing_place.domain.model.Produto;
import com.devjefiro.marketing_place.domain.model.ProdutoLoja;
import com.devjefiro.marketing_place.repository.ProdutoLojaRepository;
import com.devjefiro.marketing_place.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    LojaService lojaService;
    @Autowired
    ColaboradoService colaboradoService;
    @Autowired
    ProdutoLojaRepository produtoLojaRepository;

    public ProdutoResponseDTO addProduto(ProdutoRequestDTO requestDTO) {
        System.out.println(requestDTO);
        var colaborado = colaboradoService.getColaboradorByID(requestDTO.colaborador_id());

        Produto produto = new Produto(requestDTO);
        produto.setAddedBy(colaborado);

        int qtdEmLojas = 0;
        for (ProdutoLojaResquestDTO loja : requestDTO.lojas()) {
            qtdEmLojas += loja.quantidade();
        }
        if (produto.getQuantidade() != qtdEmLojas) {
            return null;
        }

        produto = produtoRepository.save(produto);

        for (ProdutoLojaResquestDTO lojaDTO : requestDTO.lojas()) {
            System.out.println(lojaDTO);
            var loja = lojaService.getLojaByID(lojaDTO.loja_id());

            ProdutoLoja produtoLoja = new ProdutoLoja(produto, loja, lojaDTO.quantidade());
            produtoLoja = produtoLojaRepository.save(produtoLoja);

            // Associa ao produto
            produto.getProdutosEmLojas().add(produtoLoja);
        }

        return new ProdutoResponseDTO(produto);
    }


}

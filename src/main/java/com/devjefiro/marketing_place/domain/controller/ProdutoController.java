package com.devjefiro.marketing_place.domain.controller;

import com.devjefiro.marketing_place.domain.model.DTO.produto.ProdutoRequestDTO;
import com.devjefiro.marketing_place.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @PostMapping()
    public ResponseEntity<?> newProduto(@RequestBody ProdutoRequestDTO requestDTO) {
        System.out.println(requestDTO);
        return ResponseEntity.ok(produtoService.addProduto(requestDTO));
    }
}

package com.devjefiro.marketing_place.domain.controller;

import com.devjefiro.marketing_place.domain.model.DTO.loja.LojaRequestDTO;
import com.devjefiro.marketing_place.service.LojaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/loja")
public class LojaController {
    @Autowired
    LojaService lojaService;

    @PostMapping()
    public ResponseEntity<?> add(@Valid @RequestBody LojaRequestDTO requestDTO) {
        return ResponseEntity.ok().body(lojaService.newLoja(requestDTO));
    }

    @GetMapping
    public ResponseEntity<?> listar(Pageable p) {
        var lojas = lojaService.listar(p);
        return ResponseEntity.ok(lojas);
    }


    @GetMapping("{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        return ResponseEntity.ok().body(lojaService.getById(id));
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid @RequestBody LojaRequestDTO requestDTO) {
        return ResponseEntity.ok().body(lojaService.newLoja(requestDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(lojaService.delete(id));
    }

    @GetMapping("/produto")
    public ResponseEntity<?> produtosLoja() {
        return ResponseEntity.ok().body(lojaService.produtosLoja());
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<?> produtosLoja(@PathVariable Long id) {
        return ResponseEntity.ok().body(lojaService.produtosByLojaId(id));
    }

}

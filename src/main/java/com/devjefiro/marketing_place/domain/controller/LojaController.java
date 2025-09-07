package com.devjefiro.marketing_place.domain.controller;

import com.devjefiro.marketing_place.domain.model.DTO.LojaRequestDTO;
import com.devjefiro.marketing_place.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequestMapping("/loja")
public class LojaController {
    @Autowired
    LojaService lojaService;

    @PostMapping("new")
    public ResponseEntity<?> newLoja(LojaRequestDTO requestDTO){
        return ResponseEntity.ok().body(lojaService.newLoja(requestDTO));
    }

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(lojaService.getAll());
    }


}

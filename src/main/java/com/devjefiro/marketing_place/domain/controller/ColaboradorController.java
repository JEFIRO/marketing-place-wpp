package com.devjefiro.marketing_place.domain.controller;

import com.devjefiro.marketing_place.domain.model.DTO.colaborador.ColaboradoRequestDTO;
import com.devjefiro.marketing_place.service.ColaboradoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colaborado")
public class ColaboradorController {
    @Autowired
    ColaboradoService colaboradoService;

    @PostMapping("/new")
    public ResponseEntity<?> newColaborador(@Valid @RequestBody ColaboradoRequestDTO requestDTO) {
        return ResponseEntity.ok().body(colaboradoService.addColaborador(requestDTO));
    }

}

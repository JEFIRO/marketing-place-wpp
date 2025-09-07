package com.devjefiro.marketing_place.service;

import com.devjefiro.marketing_place.domain.model.DTO.LojaRequestDTO;
import com.devjefiro.marketing_place.domain.model.DTO.LojaResponseDTO;
import com.devjefiro.marketing_place.domain.model.Loja;
import com.devjefiro.marketing_place.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LojaService {
    @Autowired
    LojaRepository lojaRepository;

    public LojaResponseDTO newLoja(LojaRequestDTO RequestDTO){
        var loja = lojaRepository.save(new Loja(RequestDTO));
        return new LojaResponseDTO(loja);
    }
    public List<LojaResponseDTO> getAll(){
        return lojaRepository.findAll().stream().map(LojaResponseDTO::new).toList();
    }
}

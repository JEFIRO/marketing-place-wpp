package com.devjefiro.marketing_place.service;

import com.devjefiro.marketing_place.domain.model.DTO.LojaRequestDTO;
import com.devjefiro.marketing_place.domain.model.DTO.LojaResponseDTO;
import com.devjefiro.marketing_place.domain.model.Endereco;
import com.devjefiro.marketing_place.domain.model.Loja;
import com.devjefiro.marketing_place.repository.EnderecoRepository;
import com.devjefiro.marketing_place.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LojaService {
    @Autowired
    LojaRepository lojaRepository;
    @Autowired
    EnderecoRepository enderecoRepository;

    public LojaResponseDTO newLoja(LojaRequestDTO requestDTO) {
        var endereco = enderecoRepository.save(new Endereco(requestDTO.endereco()));
        var loja = new Loja(requestDTO);
        loja.setEndereco(endereco);

        var response = lojaRepository.save(loja);

        return new LojaResponseDTO(response);
    }

    public List<LojaResponseDTO> getAll() {
        return lojaRepository.findAll().stream().map(LojaResponseDTO::new).toList();
    }

    public LojaResponseDTO getById(Long id) {
        return new LojaResponseDTO(lojaRepository.findById(id).get());
    }
}

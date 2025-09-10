package com.devjefiro.marketing_place.service;

import com.devjefiro.marketing_place.domain.model.Colaborado;
import com.devjefiro.marketing_place.domain.model.DTO.colaborador.ColaboradoRequestDTO;
import com.devjefiro.marketing_place.domain.model.DTO.colaborador.ColaboradoResponseDTO;
import com.devjefiro.marketing_place.repository.ColaboradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColaboradoService {
    @Autowired
    ColaboradoRepository colaboradorRepository;
    @Autowired
    LojaService lojaService;

    public ColaboradoResponseDTO addColaborador(ColaboradoRequestDTO requestDTO) {
        var colaborador = new Colaborado(requestDTO);
        var loja = lojaService.getLojaByID(Long.parseLong(requestDTO.loja_id()));
        colaborador.setLoja(loja);
        colaborador = colaboradorRepository.save(colaborador);
        return new ColaboradoResponseDTO(colaborador);
    }

    public Colaborado getColaboradorByID(Long id) {
        return colaboradorRepository.findById(id).get();
    }
}

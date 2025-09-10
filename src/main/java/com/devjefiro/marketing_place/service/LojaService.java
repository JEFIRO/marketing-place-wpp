package com.devjefiro.marketing_place.service;


import com.devjefiro.marketing_place.domain.model.DTO.loja.LojaRequestDTO;
import com.devjefiro.marketing_place.domain.model.DTO.loja.LojaResponseDTO;
import com.devjefiro.marketing_place.domain.model.DTO.loja.LojaUpdateDTO;
import com.devjefiro.marketing_place.domain.model.DTO.produto.ProdutoDetalhadoResponseDTO;
import com.devjefiro.marketing_place.domain.model.Endereco;
import com.devjefiro.marketing_place.domain.model.Loja;
import com.devjefiro.marketing_place.repository.EnderecoRepository;
import com.devjefiro.marketing_place.repository.LojaRepository;
import com.devjefiro.marketing_place.repository.ProdutoLojaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LojaService {
    @Autowired
    LojaRepository lojaRepository;
    @Autowired
    ProdutoLojaRepository produtoLojaRepository;
    @Autowired
    EnderecoRepository enderecoRepository;

    public LojaResponseDTO newLoja(LojaRequestDTO requestDTO) {
        var endereco = enderecoRepository.save(new Endereco(requestDTO.endereco()));
        var loja = new Loja(requestDTO);
        loja.setEndereco(endereco);

        var response = lojaRepository.save(loja);

        return new LojaResponseDTO(response);
    }

    public Page<LojaResponseDTO> listar(Pageable pageable) {
        return lojaRepository.findAll(pageable)
                .map(LojaResponseDTO::new);
    }

    public LojaResponseDTO getById(Long id) {
        return new LojaResponseDTO(lojaRepository.findById(id).get());
    }

    public Loja getLojaByID(Long id) {
        return lojaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Loja não encontrada"));
    }

    public boolean delete(Long id) {
        var loja = lojaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Loja não encontrada"));
        loja.setStatus(false);
        loja.setDataExclusao(java.time.LocalDateTime.now());
        lojaRepository.save(loja);
        return true;
    }

    @Transactional
    public LojaResponseDTO update(LojaUpdateDTO requestDTO) {
        var loja = lojaRepository.findById(requestDTO.id())
                .orElseThrow(() -> new EntityNotFoundException("Loja não encontrada"));

        loja.setNome(requestDTO.nome());
        loja.setTelefone(requestDTO.telefone());
        loja.setInstagram(requestDTO.instagram());
        loja.setStatus(requestDTO.status());
        loja.setDataAtualizacao(java.time.LocalDateTime.now());

        loja = lojaRepository.save(loja);

        return new LojaResponseDTO(loja);
    }

    // busca produto da loja por iD
    public List<ProdutoDetalhadoResponseDTO> produtosByLojaId(Long id) {
        return produtoLojaRepository.findByLojaId(id).stream().map(ProdutoDetalhadoResponseDTO::new).toList();
    }

    public List<ProdutoDetalhadoResponseDTO> produtosLoja(Pageable pageable) {
        return produtoLojaRepository.findAll(pageable).stream().map(ProdutoDetalhadoResponseDTO::new).toList();
    }
}

package com.devjefiro.marketing_place.service;

import com.devjefiro.marketing_place.domain.model.DTO.loja.LojaRequestDTO;
import com.devjefiro.marketing_place.domain.model.DTO.loja.LojaResponseDTO;
import com.devjefiro.marketing_place.domain.model.DTO.produto.ProdutoDetalhadoResponseDTO;
import com.devjefiro.marketing_place.domain.model.Endereco;
import com.devjefiro.marketing_place.domain.model.Loja;
import com.devjefiro.marketing_place.domain.model.ProdutoLoja;
import com.devjefiro.marketing_place.repository.EnderecoRepository;
import com.devjefiro.marketing_place.repository.LojaRepository;
import com.devjefiro.marketing_place.repository.ProdutoLojaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<LojaResponseDTO> getAll() {
        return lojaRepository.findAll().stream().map(LojaResponseDTO::new).toList();
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
    public LojaResponseDTO update(LojaRequestDTO requestDTO) {
        var loja = lojaRepository.findById(requestDTO.id())
                .orElseThrow(() -> new EntityNotFoundException("Loja não encontrada"));

        var endereco = enderecoRepository.findById(loja.getEndereco().getId())
                .orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado"));


        endereco.setLogradouro(requestDTO.endereco().logradouro());
        endereco.setNumero(requestDTO.endereco().numero());
        endereco.setBairro(requestDTO.endereco().bairro());
        endereco.setCidade(requestDTO.endereco().cidade());
        endereco.setEstado(requestDTO.endereco().estado());
        enderecoRepository.save(endereco);


        loja.setNome(requestDTO.nome());
        loja.setCnpj(requestDTO.cnpj());
        loja.setTelefone(requestDTO.telefone());
        loja.setEndereco(endereco);

        loja = lojaRepository.save(loja);

        return new LojaResponseDTO(loja);
    }

    public List<ProdutoDetalhadoResponseDTO> produtosByLojaId(Long id) {
        return produtoLojaRepository.findByLojaId(id).stream().map(ProdutoDetalhadoResponseDTO::new).toList();
    }

    public List<ProdutoDetalhadoResponseDTO> produtosLoja() {
        return produtoLojaRepository.findAll().stream().map(ProdutoDetalhadoResponseDTO::new).toList();
    }
}

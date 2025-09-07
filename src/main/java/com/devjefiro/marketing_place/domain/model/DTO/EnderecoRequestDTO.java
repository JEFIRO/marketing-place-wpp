package com.devjefiro.marketing_place.domain.model.DTO;

public record EnderecoRequestDTO(
        String cep,
        String logradouro,
        String bairro,
        String cidade,
        String estado) {
}

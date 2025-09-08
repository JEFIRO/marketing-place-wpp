package com.devjefiro.marketing_place.domain.model.DTO.loja;

import com.devjefiro.marketing_place.domain.model.DTO.EnderecoRequestDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LojaRequestDTO(
        long id,
        @NotNull
        String nome,
        @NotNull
        EnderecoRequestDTO endereco,
        @NotNull@Size(min = 14, max = 14,message = "CNPJ deve ter 14 digitos")
        String cnpj,
        String telefone
) {
}

package com.devjefiro.marketing_place.repository;

import com.devjefiro.marketing_place.domain.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}

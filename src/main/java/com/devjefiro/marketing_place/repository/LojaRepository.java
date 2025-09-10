package com.devjefiro.marketing_place.repository;

import com.devjefiro.marketing_place.domain.model.Loja;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LojaRepository extends JpaRepository<Loja, Long> {
    Page<Loja> findAll(Pageable pageable);

}

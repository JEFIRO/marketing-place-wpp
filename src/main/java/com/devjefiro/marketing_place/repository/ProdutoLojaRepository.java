package com.devjefiro.marketing_place.repository;

import com.devjefiro.marketing_place.domain.model.ProdutoLoja;
import com.devjefiro.marketing_place.domain.model.ProdutoLojaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoLojaRepository extends JpaRepository<ProdutoLoja, ProdutoLojaId> {
}

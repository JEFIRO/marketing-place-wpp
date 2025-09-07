package com.devjefiro.marketing_place.repository;

import com.devjefiro.marketing_place.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

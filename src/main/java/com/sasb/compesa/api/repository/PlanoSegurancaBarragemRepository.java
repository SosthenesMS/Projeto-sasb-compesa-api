package com.sasb.compesa.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sasb.compesa.api.model.PlanoSegurancaBarragem;

public interface PlanoSegurancaBarragemRepository extends JpaRepository<PlanoSegurancaBarragem, Integer> {

    PlanoSegurancaBarragem findByStatusLike(String status);

    Page<PlanoSegurancaBarragem> findAll(Pageable pageable);

}

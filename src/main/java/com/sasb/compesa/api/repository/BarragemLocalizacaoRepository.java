package com.sasb.compesa.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sasb.compesa.api.model.BarragemLocalizacao;

public interface BarragemLocalizacaoRepository extends JpaRepository<BarragemLocalizacao, Integer> {

    Page<BarragemLocalizacao> findAll(Pageable pageable);

}

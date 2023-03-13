package com.sasb.compesa.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sasb.compesa.api.model.RelatorioInspecao;

public interface RelatorioInspecaoRepository extends JpaRepository<RelatorioInspecao, Integer> {

    Page<RelatorioInspecao> findAll(Pageable pageable);
}

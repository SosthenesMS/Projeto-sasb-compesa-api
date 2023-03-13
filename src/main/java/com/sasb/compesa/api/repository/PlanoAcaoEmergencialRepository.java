package com.sasb.compesa.api.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sasb.compesa.api.model.PlanoAcaoEmergencial;

public interface PlanoAcaoEmergencialRepository extends JpaRepository<PlanoAcaoEmergencial, Integer> {

    Page<PlanoAcaoEmergencial> findAll(Pageable pageable);
    
}

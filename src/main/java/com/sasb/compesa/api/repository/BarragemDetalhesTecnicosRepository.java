package com.sasb.compesa.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sasb.compesa.api.model.BarragemDetalhesTecnicos;

@Repository
public interface BarragemDetalhesTecnicosRepository extends JpaRepository<BarragemDetalhesTecnicos, Integer> {

}

package com.sasb.compesa.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sasb.compesa.api.model.Barragem;

public interface BarragemRepository extends JpaRepository<Barragem, Integer> {

    Barragem findByNomeLike(String string);
}

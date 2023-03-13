package com.sasb.compesa.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sasb.compesa.api.model.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {

    TipoUsuario findByNomeLike(String nome);

}

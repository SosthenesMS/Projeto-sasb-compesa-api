package com.sasb.compesa.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sasb.compesa.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    
}

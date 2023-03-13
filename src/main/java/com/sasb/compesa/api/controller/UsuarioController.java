package com.sasb.compesa.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sasb.compesa.api.model.Usuario;
import com.sasb.compesa.api.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Usuario> criarNovoUsuario(@RequestBody Usuario usuario) {

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));

    }

    @GetMapping
    public ResponseEntity<List<Usuario>> obterUsuarios() {

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.findAll());

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Usuario>> obterUsuarioPeloId(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findById(id));
    }

    @PutMapping
    public ResponseEntity<Usuario> atualizaUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable("id") int id) {
        usuarioRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso!");
    }

}

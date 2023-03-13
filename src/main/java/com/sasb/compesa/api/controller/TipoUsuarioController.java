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

import com.sasb.compesa.api.model.TipoUsuario;
import com.sasb.compesa.api.repository.TipoUsuarioRepository;

@RestController
@RequestMapping(value = "/usuarios/tipo")
public class TipoUsuarioController {

    @PostMapping
    public ResponseEntity<TipoUsuario> criarNovoTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoUsuarioRepository.save(tipoUsuario));
    }

    @GetMapping
    public ResponseEntity<List<TipoUsuario>> obterTodosTiposUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(tipoUsuarioRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public Optional<TipoUsuario> obterTipoUsuarioPeloId(@PathVariable("id") int id) {
        return tipoUsuarioRepository.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public String deletarTipoUsuarioPeloId(@PathVariable("id") int id) {
        tipoUsuarioRepository.deleteById(id);

        return "Tipo de Usuário deletado com sucesso!";
    }

    @PutMapping
    public TipoUsuario atualizarTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        TipoUsuario tipoUsuarioBD = tipoUsuarioRepository.findById(tipoUsuario.getIdTipoUsuario()).get();

        tipoUsuarioBD.setNome(tipoUsuario.getNome());

        return tipoUsuarioRepository.save(tipoUsuarioBD);

    }

    @GetMapping(value = "/nome/{nome}")
    public TipoUsuario obterTipoUsuarioPeloNome(@PathVariable("nome") String nome) {
        return tipoUsuarioRepository.findByNomeLike(nome + "%");
    }

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

}

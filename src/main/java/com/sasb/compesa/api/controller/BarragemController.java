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

import com.sasb.compesa.api.model.Barragem;
import com.sasb.compesa.api.repository.BarragemRepository;

@RestController
@RequestMapping(value = "/barragens")
public class BarragemController {

    @PostMapping
    public ResponseEntity<Barragem> criarNovaBarragem(@RequestBody Barragem barragem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(barragemRepository.save(barragem));
    }

    @GetMapping
    public ResponseEntity<List<Barragem>> obterTodasBarragens() {
        return ResponseEntity.status(HttpStatus.OK).body(barragemRepository.findAll());

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Barragem>> obterBarragemPeloId(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(barragemRepository.findById(id));
    }

    @PutMapping
    public ResponseEntity<Barragem> atualizarBarragem(@RequestBody Barragem barragem) {
        return ResponseEntity.status(HttpStatus.OK).body(barragemRepository.save(barragem));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarBarragemPeloId(@PathVariable("id") int id) {
        barragemRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Barragem deletada com sucesso!");
    }

    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<Barragem> obterBarragemPeloNome(@PathVariable("nome") String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(barragemRepository.findByNomeLike(nome + "%"));

    }

    @Autowired
    private BarragemRepository barragemRepository;

}

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

import com.sasb.compesa.api.model.BarragemDetalhesTecnicos;
import com.sasb.compesa.api.repository.BarragemDetalhesTecnicosRepository;

@RestController
@RequestMapping(value = "/barragens/detalhes")
public class BarragemDetalhesTecnicosController {

    @GetMapping
    public ResponseEntity<List<BarragemDetalhesTecnicos>> obterTodosDetalhesTecnicos() {
        return ResponseEntity.status(HttpStatus.OK).body(barragemDetalhesTecnicosRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<BarragemDetalhesTecnicos>> obterDetalhesPorId(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(barragemDetalhesTecnicosRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<BarragemDetalhesTecnicos> criarDetalhesTecnicos(
            @RequestBody BarragemDetalhesTecnicos barragemDetalhesTecnicos) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(barragemDetalhesTecnicosRepository.save(barragemDetalhesTecnicos));
    }

    @PutMapping
    public ResponseEntity<BarragemDetalhesTecnicos> alterarDetalhesTecnicos(
            @RequestBody BarragemDetalhesTecnicos barragemDetalhesTecnicos) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(barragemDetalhesTecnicosRepository.save(barragemDetalhesTecnicos));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarDetalhesTecnicos(@PathVariable("id") int id) {
        barragemDetalhesTecnicosRepository.getReferenceById(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Detalhes da barragem deletados.");
    }

    @Autowired
    private BarragemDetalhesTecnicosRepository barragemDetalhesTecnicosRepository;

}

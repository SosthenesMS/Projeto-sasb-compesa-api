package com.sasb.compesa.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sasb.compesa.api.model.PlanoAcaoEmergencial;
import com.sasb.compesa.api.repository.PlanoAcaoEmergencialRepository;

@RestController
@RequestMapping(value = "/barragens/pae")
public class PlanoAcaoEmergencialController {

    @PostMapping
    public ResponseEntity<Object> criarPlanoAcaoEmergencial(@RequestBody PlanoAcaoEmergencial planoAcaoEmergencial) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(planoAcaoRepository.save(planoAcaoEmergencial));
        } catch (DataIntegrityViolationException d) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito na criacao do plano de acao emergencial!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar plano de acao emergencial.");
        }
    }

    @GetMapping
    public ResponseEntity<Page<PlanoAcaoEmergencial>> obterTodosPlanos(
            @RequestParam(value = "page", defaultValue = "0") String page,
            @RequestParam(value = "size", defaultValue = "5") String size) {

        Pageable paging = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
        return ResponseEntity.status(HttpStatus.OK).body(planoAcaoRepository.findAll(paging));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<PlanoAcaoEmergencial>> obterPlanoAcaoEmergencial(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(planoAcaoRepository.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarPlanoAcaoEmergencial(@PathVariable("id") int id) {
        planoAcaoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Plano de acao emergencial deletado com sucesso!");
    }

    @PutMapping
    public ResponseEntity<PlanoAcaoEmergencial> atualizarPlanoAcaoEmergencial(
            @RequestBody PlanoAcaoEmergencial planoAcaoEmergencial) {
        return ResponseEntity.status(HttpStatus.OK).body(planoAcaoRepository.save(planoAcaoEmergencial));
    }

    @Autowired
    private PlanoAcaoEmergencialRepository planoAcaoRepository;
}

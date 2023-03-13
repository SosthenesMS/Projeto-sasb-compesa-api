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

import com.sasb.compesa.api.model.PlanoSegurancaBarragem;
import com.sasb.compesa.api.repository.PlanoSegurancaBarragemRepository;

@RestController
@RequestMapping(value = "/barragens/psb")
public class PlanoSegurancaBarragemController {

    @PostMapping
    public ResponseEntity<Object> criarNovoPSB(@RequestBody PlanoSegurancaBarragem psb) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(psbRepository.save(psb));
        } catch (DataIntegrityViolationException d) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Plano já existe." + d.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao criar Plano de Segurança de Barragem." + e.getMessage());
        }
    }

    @GetMapping
    public Page<PlanoSegurancaBarragem> obterTodosPSB(

            @RequestParam(value = "page", defaultValue = "0") String page,
            @RequestParam(value = "size", defaultValue = "5") String size) {

        Pageable paging = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));

        return psbRepository.findAll(paging);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<PlanoSegurancaBarragem>> obterPSBPeloId(@PathVariable("id") int idPsb) {
        return ResponseEntity.status(HttpStatus.OK).body(psbRepository.findById(idPsb));

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarPSBPeloId(@PathVariable("id") int idPsb) {
        try {
            psbRepository.deleteById(idPsb);
            return ResponseEntity.status(HttpStatus.OK).body("Plano Segurança deletado com Sucesso !");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ops! Id não encontrada !." + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Object> atualizarPSB(@RequestBody PlanoSegurancaBarragem psb) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(psbRepository.save(psb));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Ops! Não consegui atualizar este Plano !. Verifica a mensagem : " + e.getMessage());
        }
    }

    @GetMapping(value = "/status/{status}")
    public PlanoSegurancaBarragem obterPSBPeloStatus(@PathVariable("status") String status) {
        return psbRepository.findByStatusLike("%" + status + "%");

    }

    @Autowired
    private PlanoSegurancaBarragemRepository psbRepository;

}

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
import com.sasb.compesa.api.model.BarragemLocalizacao;
import com.sasb.compesa.api.repository.BarragemLocalizacaoRepository;

@RestController
@RequestMapping(value = "/barragens/localizacao")
public class BarragemLocalizacaoController {

    @PostMapping
    public ResponseEntity<Object> criarNovaBarragemLocalizacao(@RequestBody BarragemLocalizacao barragemLocalizacao) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(barragemLocalizacaoRepository.save(barragemLocalizacao));
        } catch (DataIntegrityViolationException d) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao tentar salvar localização da barragem.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao fazer a requisição.");
        }
    }

    @GetMapping
    public ResponseEntity<Page<BarragemLocalizacao>> obterBarragemLocalizacoes(
            @RequestParam(value = "page", defaultValue = "0") String page,
            @RequestParam(value = "size", defaultValue = "5") String size) {
        Pageable paging = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));

        return ResponseEntity.status(HttpStatus.OK).body(barragemLocalizacaoRepository.findAll(paging));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<BarragemLocalizacao>> obterBarragemLocalizacao(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(barragemLocalizacaoRepository.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarBarragemLocalizacao(@PathVariable("id") int id) {
        barragemLocalizacaoRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Localizacao da barragem deletada com sucesso!");
    }

    @PutMapping
    public ResponseEntity<Object> atualizarBarragemLocalizacao(
            @RequestBody BarragemLocalizacao barragemLocalizacao) {
        if (barragemLocalizacaoRepository.existsById(barragemLocalizacao.getIdBarragemLocalizacao())) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    barragemLocalizacaoRepository.save(barragemLocalizacao));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Essa localizacao ja existe");
        }
    }

    @Autowired
    private BarragemLocalizacaoRepository barragemLocalizacaoRepository;

}

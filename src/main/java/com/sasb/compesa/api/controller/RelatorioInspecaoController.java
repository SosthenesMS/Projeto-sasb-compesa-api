package com.sasb.compesa.api.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.sasb.compesa.api.model.RelatorioInspecao;
import com.sasb.compesa.api.repository.RelatorioInspecaoRepository;

@RestController
@RequestMapping(value = "/inspecao/relatorios")
public class RelatorioInspecaoController {

    @GetMapping
    public Page<RelatorioInspecao> obterRelatoriosInspecao(
            @RequestParam(value = "page", defaultValue = "0") String page,
            @RequestParam(value = "size", defaultValue = "5") String size) {

        Pageable paging = PageRequest.of(Integer.parseInt(page),
                Integer.parseInt(size));

        return relatorioInspecaoRepository.findAll(paging);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<RelatorioInspecao>> obterRelatorioInspecaoPeloId(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(relatorioInspecaoRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> criarNovoRelatorioInspecao(@RequestBody RelatorioInspecao relatorioInspecao) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(relatorioInspecaoRepository.save(relatorioInspecao));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar o relatorio " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Object> atualizarRelatorioInspecao(@RequestBody RelatorioInspecao relatorioInspecao) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(relatorioInspecaoRepository.save(relatorioInspecao));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar " + e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarRelatoriosInspecao(@PathVariable("id") int id) {
        relatorioInspecaoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Relatório deletado com sucesso!");
    }

    @Autowired
    private RelatorioInspecaoRepository relatorioInspecaoRepository;

}

package com.sasb.compesa.api.controller;

import java.util.List;

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

import com.sasb.compesa.api.service.InspecaoService;
import com.sasb.compesa.api.dto.InspecaoDto;
import com.sasb.compesa.api.model.Inspecao;

@RestController
@RequestMapping(value = "/inspecoes")
public class InspecaoController {

    @PostMapping
    public ResponseEntity<InspecaoDto> criarNovoInspecao(@RequestBody Inspecao inspecao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inspecaoService.criarInspecao(inspecao));
    }

    @GetMapping
    public ResponseEntity<List<InspecaoDto>> obterTodosInspecao() {
        return ResponseEntity.status(HttpStatus.OK).body(inspecaoService.obterTodasInspecoes());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<InspecaoDto> obterInspecaoPeloId(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(inspecaoService.obterInspecao(id));
    }

    @PutMapping
    public ResponseEntity<InspecaoDto> atualizarInspecaoPorId(@RequestBody Inspecao inspecao) {
        return ResponseEntity.status(HttpStatus.OK).body(inspecaoService.atualizarInspecao(inspecao));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarInspecao(@PathVariable("id") int id) {
        inspecaoService.deletarInspecao(id);

        return ResponseEntity.status(HttpStatus.OK).body("Inspeção deletada com sucesso");
    }

    @Autowired
    private InspecaoService inspecaoService;

}

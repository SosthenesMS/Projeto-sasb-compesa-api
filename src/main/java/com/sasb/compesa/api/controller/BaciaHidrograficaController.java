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
import com.sasb.compesa.api.model.BaciaHidrografica;
import com.sasb.compesa.api.repository.BaciaHidrograficaRepository;

@RestController
@RequestMapping(value = "/bacias")
public class BaciaHidrograficaController {

    @PostMapping
    public ResponseEntity<BaciaHidrografica> criarNovaBaciaHidrografica(
            @RequestBody BaciaHidrografica baciaHidrografica) {
        return ResponseEntity.status(HttpStatus.CREATED).body(baciaHidrograficaRepository.save(baciaHidrografica));
    }

    @GetMapping
    public ResponseEntity<List<BaciaHidrografica>> obterTodasBaciasHidrograficas() {
        return ResponseEntity.status(HttpStatus.OK).body(baciaHidrograficaRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<BaciaHidrografica>> obterBaciaHidrografica(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(baciaHidrograficaRepository.findById(id));
    }

    @PutMapping
    public ResponseEntity<BaciaHidrografica> atualizarBarciaHidrografica(
            @RequestBody BaciaHidrografica baciaHidrografica) {
        return ResponseEntity.status(HttpStatus.OK).body(baciaHidrograficaRepository.save(baciaHidrografica));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable("id") int id) {
        baciaHidrograficaRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Bacia Hidrográfica deletada com sucesso!");
    }

    @Autowired
    private BaciaHidrograficaRepository baciaHidrograficaRepository;

}

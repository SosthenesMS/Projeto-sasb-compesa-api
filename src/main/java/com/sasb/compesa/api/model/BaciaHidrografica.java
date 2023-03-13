package com.sasb.compesa.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_bacia_hidrografica")
public class BaciaHidrografica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBaciaHidrografica;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "area", nullable = false)
    private double area;

}

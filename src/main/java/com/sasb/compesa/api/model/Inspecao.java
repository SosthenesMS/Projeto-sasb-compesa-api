package com.sasb.compesa.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_inspecao")
public class Inspecao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInspecao;

    // @Column(name = "status", length = 45)
    // private String status;

    @Column(name = "mes")
    private int mes;

    @Column(name = "prioridade")
    private int prioridade;

    @Column(name = "frequencia", length = 45)
    private String frequencia;

    @Column(name = "responsavel", length = 70)
    private String responsavel;

    @OneToOne
    @JoinColumn(name = "idBarragem")
    private Barragem barragem;

}
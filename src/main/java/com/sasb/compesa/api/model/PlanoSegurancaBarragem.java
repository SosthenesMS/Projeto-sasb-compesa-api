package com.sasb.compesa.api.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "tb_psb")
public class PlanoSegurancaBarragem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPsb;

    @Column(length = 45, name = "status", nullable = false)
    private String status;

    @Column(name = "dataDeEntrega", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeEntrega;

    @Column(columnDefinition = "TEXT", name = "link", nullable = false)
    private String link;

    @OneToOne
    @JoinColumn(name = "idBarragem")
    private Barragem barragem;

}

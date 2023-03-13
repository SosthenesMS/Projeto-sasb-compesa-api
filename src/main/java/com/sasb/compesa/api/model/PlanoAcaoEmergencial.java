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
@Entity(name = "tb_pae")
public class PlanoAcaoEmergencial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPae;

    @Column(length = 45, nullable = false)
    private String status;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeEntrega;

    @Column(nullable = false)
    private String link;

    @OneToOne
    @JoinColumn(name = "idBarragem")
    private Barragem barragem;

}

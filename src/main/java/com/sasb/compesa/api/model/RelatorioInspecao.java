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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_RelatorioInspecao")
public class RelatorioInspecao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRelatorioInspecao;

    @Column(name = "status", length = 45)
    private String status;

    @Column(name = "tipo", length = 45)
    private String tipo;

    @Column(name = "data")
    @JsonFormat(pattern = "dd/MM/yyy")
    private LocalDate data;

    @Column(name = "link", columnDefinition = "TEXT")
    private String link;

    @Column(name = "inspetor", length = 70)
    private String inspetor;

    @OneToOne
    @JoinColumn(name = "idInspecao")
    private Inspecao inspecao;

}

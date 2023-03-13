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
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_barragem")
public class Barragem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBarragem;

    @Column(name = "nome", nullable = false, length = 200)
    private String nome;

    @Column(name = "diretoria", length = 45)
    private String diretoria;

    @Column(name = "gerencia", length = 45)
    private String gerencia;

    @Column(name = "coordenacao", length = 45)
    private String coordenacao;

    @Column(name = "titularidade", length = 45)
    private String titularidade;

    @Column(name = "anoConstrucao", length = 45)
    private String anoConstrucao;

    @Column(name = "classificacaoDeRisco", length = 45)
    private String classificacaoDeRisco;

    @Column(name = "danoPotencialAssociado", length = 45)
    private String danoPotencialAssociado;

    @Column(name = "outorgaCaptacao", length = 45)
    private String outorgaCaptacao;

    @Column(name = "outorgaObraHidrica", length = 45)
    private String outorgaObraHidrica;

    @OneToOne
    @JoinColumn(name = "idBaciaHidrografica")
    private BaciaHidrografica baciaHidrografica;

}

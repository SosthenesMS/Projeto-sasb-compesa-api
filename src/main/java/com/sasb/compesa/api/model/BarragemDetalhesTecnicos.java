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
@Entity(name = "tb_barragem_detalhes_tecnicos")
public class BarragemDetalhesTecnicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBarragemDetalhesTecnicos;

    private double volume;
    private double altura;
    private double areaInundada;
    private double cotaDoCoroamento;
    private double comprimento;
    private double profundidadeMedia;
    private double profundidadeMaxima;
    private double descargaDeFundo;

    @Column(length = 45)
    private String cursoDeAguaBarrado;

    @Column(length = 45)
    private String tipo;

    @Column(length = 45)
    private String material;


    @OneToOne
    @JoinColumn(name = "idBarragem")
    private Barragem barragem;

}

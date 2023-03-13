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
@Entity(name = "tb_barragem_localizacao")
public class BarragemLocalizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBarragemLocalizacao;

    @Column(name = "municipio", length = 45, nullable = true)
    private String municipio;

    @Column(name = "estado", length = 45, nullable = true)
    private String estado;

    @Column(name = "latitude", length = 45)
    private String latitude;

    @Column(name = "longitude", length = 45)
    private String longitude;

    @Column(name = "linkGoogleEarth", columnDefinition = "TEXT")
    private String linkGoogleEarth;

    @Column(name = "sistemaDeCoordenadas", length = 45)
    private String sistemaDeCoordenadas;

    @OneToOne
    @JoinColumn(name = "idBarragem")
    private Barragem barragem;

}

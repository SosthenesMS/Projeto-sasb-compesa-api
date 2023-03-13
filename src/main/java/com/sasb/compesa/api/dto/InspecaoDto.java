package com.sasb.compesa.api.dto;

import com.sasb.compesa.api.model.Barragem;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspecaoDto {

    private int idInspecao;

    private String status;

    private int mes;

    private int prioridade;

    private String frequencia;

    private String responsavel;

    private Barragem barragem;
}

package com.sasb.compesa.api.mapper;

import java.time.LocalDate;

import com.sasb.compesa.api.dto.InspecaoDto;
import com.sasb.compesa.api.model.Inspecao;

public class InspecaoMapper {
    public static InspecaoDto toDto(Inspecao inspecao) {
        InspecaoDto inspecaoDto = new InspecaoDto();
        inspecaoDto.setIdInspecao(inspecao.getIdInspecao());
        inspecaoDto.setBarragem(inspecao.getBarragem());
        inspecaoDto.setFrequencia(inspecao.getFrequencia());
        inspecaoDto.setMes(inspecao.getMes());
        inspecaoDto.setPrioridade(inspecao.getPrioridade());
        inspecaoDto.setResponsavel(inspecao.getFrequencia());
        int mesInspecao = inspecao.getMes();
        int mesAtual = LocalDate.now().getMonthValue();

        if (mesInspecao >= mesAtual) {
            inspecaoDto.setStatus("EM DIA");
        } else {
            inspecaoDto.setStatus("PENDENTE");
        }

        return inspecaoDto;
    }
}

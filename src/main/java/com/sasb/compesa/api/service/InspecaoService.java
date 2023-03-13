package com.sasb.compesa.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasb.compesa.api.dto.InspecaoDto;
import com.sasb.compesa.api.mapper.InspecaoMapper;
import com.sasb.compesa.api.model.Inspecao;
import com.sasb.compesa.api.repository.InspecaoRepository;

@Service
public class InspecaoService {
    @Autowired
    private InspecaoRepository inspecaoRepository;

    public InspecaoDto obterInspecao(int id) {
        Optional<Inspecao> inspecao = inspecaoRepository.findById(id);
        if (Objects.nonNull(inspecao)) {
            Inspecao inspecao2 = inspecao.get();

            return InspecaoMapper.toDto(inspecao2);
        }
        return null;
    }

    public InspecaoDto criarInspecao(Inspecao inspecao) {

        inspecaoRepository.save(inspecao);

        return InspecaoMapper.toDto(inspecao);
    }

    public List<InspecaoDto> obterTodasInspecoes() {
        List<Inspecao> list = inspecaoRepository.findAll();
        List<InspecaoDto> listdto = new ArrayList<>();

        for (Inspecao x : list) {
            listdto.add(InspecaoMapper.toDto(x));
        }

        return listdto;
    }

    public InspecaoDto atualizarInspecao(Inspecao inspecao) {

        inspecaoRepository.save(inspecao);

        InspecaoDto inspecaoDto = InspecaoMapper.toDto(inspecao);

        return inspecaoDto;
    }

    public void deletarInspecao(int id) {
        Optional<Inspecao> inspecao = inspecaoRepository.findById(id);
        if (Objects.nonNull(inspecao)) {
            Inspecao inspecao2 = inspecao.get();
            inspecaoRepository.deleteById(inspecao2.getIdInspecao());
        }
    }

}

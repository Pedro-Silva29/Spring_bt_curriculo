package com.example.demo.service;

import com.example.demo.model.Formacao;
import com.example.demo.repository.FormacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class FormacaoService {
    @Autowired
    private FormacaoRepository formacaoRepository;

    public List<Formacao> getAllFormacoes() {
        return formacaoRepository.findAll();
    }

    @Transactional
    public Formacao updateFormacao(Long id, Formacao formacaoDetails) {
        Formacao formacao = formacaoRepository.findById(id).orElse(null);
        if (formacao == null) {
            return null;
        }
        formacao.setInstituicao(formacaoDetails.getInstituicao());
        formacao.setCurso(formacaoDetails.getCurso());
        formacao.setAnoI(formacaoDetails.getAnoI());
        formacao.setAnoF(formacaoDetails.getAnoF());
        return formacaoRepository.save(formacao);
    }

    @Transactional
    public boolean deleteFormacao(Long id) {
        if (!formacaoRepository.existsById(id)) {
            return false;
        }
        formacaoRepository.deleteById(id);
        return true;
    }
}

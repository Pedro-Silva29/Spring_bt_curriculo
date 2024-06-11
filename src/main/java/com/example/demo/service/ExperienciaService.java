package com.example.demo.service;

import com.example.demo.model.Experiencia;
import com.example.demo.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class ExperienciaService {
    @Autowired
    private ExperienciaRepository experienciaRepository;

    public List<Experiencia> getAllExperiencias() {
        return experienciaRepository.findAll();
    }

    @Transactional
    public Experiencia updateExperiencia(Long id, Experiencia experienciaDetails) {
        Experiencia experiencia = experienciaRepository.findById(id).orElse(null);
        if (experiencia == null) {
            return null;
        }
        experiencia.setEmpresa(experienciaDetails.getEmpresa());
        experiencia.setCargo(experienciaDetails.getCargo());
        experiencia.setDescricao(experienciaDetails.getDescricao());
        experiencia.setAnoI(experienciaDetails.getAnoI());
        experiencia.setAnoF(experienciaDetails.getAnoF());
        return experienciaRepository.save(experiencia);
    }

    @Transactional
    public boolean deleteExperiencia(Long id) {
        if (!experienciaRepository.existsById(id)) {
            return false;
        }
        experienciaRepository.deleteById(id);
        return true;
    }
}

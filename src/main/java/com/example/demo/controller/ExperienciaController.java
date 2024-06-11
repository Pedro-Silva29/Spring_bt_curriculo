package com.example.demo.controller;

import com.example.demo.model.Experiencia;
import com.example.demo.repository.ExperienciaRepository;
import com.example.demo.service.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiencia")
public class ExperienciaController {
    @Autowired
    private ExperienciaService experienciaService;
    @Autowired
    private ExperienciaRepository experienciaRepository;

    @GetMapping
    public ResponseEntity<List<Experiencia>> getAllExperiencias() {
        List<Experiencia> experiencias = experienciaService.getAllExperiencias();
        return ResponseEntity.ok(experiencias);
    }

    @PostMapping
    public Experiencia createExperiencia(@RequestBody Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experiencia> updateExperiencia(@PathVariable Long id, @RequestBody Experiencia experienciaDetails) {
        Experiencia updatedExperiencia = experienciaService.updateExperiencia(id, experienciaDetails);
        if (updatedExperiencia == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedExperiencia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperiencia(@PathVariable Long id) {
        boolean deleted = experienciaService.deleteExperiencia(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

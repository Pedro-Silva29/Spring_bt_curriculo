package com.example.demo.controller;

import com.example.demo.model.Formacao;
import com.example.demo.repository.FormacaoRepository;
import com.example.demo.service.FormacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formacao")
public class FormacaoController {
    @Autowired
    private FormacaoService formacaoService;
    @Autowired
    private FormacaoRepository formacaoRepository;

    @GetMapping
    public ResponseEntity<List<Formacao>> getAllFormacoes() {
        List<Formacao> formacoes = formacaoService.getAllFormacoes();
        return ResponseEntity.ok(formacoes);
    }

    @PostMapping
    public Formacao createFormacao(@RequestBody Formacao formacao) {
        return formacaoRepository.save(formacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Formacao> updateFormacao(@PathVariable Long id, @RequestBody Formacao formacaoDetails) {
        Formacao updatedFormacao = formacaoService.updateFormacao(id, formacaoDetails);
        if (updatedFormacao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedFormacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormacao(@PathVariable Long id) {
        boolean deleted = formacaoService.deleteFormacao(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

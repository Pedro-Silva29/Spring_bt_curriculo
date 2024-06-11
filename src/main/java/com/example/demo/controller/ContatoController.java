package com.example.demo.controller;

import com.example.demo.model.Contato;
import com.example.demo.model.Experiencia;
import com.example.demo.repository.ContatoRepository;
import com.example.demo.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contato")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;
    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping
    public ResponseEntity<List<Contato>> getAllContatos() {
        List<Contato> contatos = contatoService.getAllContatos();
        return ResponseEntity.ok(contatos);
    }

    @PostMapping
    public Contato createContato(@RequestBody Contato contato) {
        return contatoRepository.save(contato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> updateContato(@PathVariable Long id, @RequestBody Contato contatoDetails) {
        Contato updatedContato = contatoService.updateContato(id, contatoDetails);
        if (updatedContato == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedContato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContato(@PathVariable Long id) {
        boolean deleted = contatoService.deleteContato(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

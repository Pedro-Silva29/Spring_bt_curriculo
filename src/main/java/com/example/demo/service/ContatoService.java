package com.example.demo.service;

import com.example.demo.model.Contato;
import com.example.demo.repository.ContatoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;

    public List<Contato> getAllContatos() {
        return contatoRepository.findAll();
    }

    @Transactional
    public Contato updateContato(Long id, Contato contatoDetails) {
        Contato contato = contatoRepository.findById(id).orElse(null);
        if (contato == null) {
            return null;
        }
        contato.setNome(contatoDetails.getNome());
        contato.setEmail(contatoDetails.getEmail());
        contato.setTelefone(contatoDetails.getTelefone());
        contato.setLinkedin(contatoDetails.getLinkedin());
        return contatoRepository.save(contato);
    }

    @Transactional
    public boolean deleteContato(Long id) {
        if (!contatoRepository.existsById(id)) {
            return false;
        }
        contatoRepository.deleteById(id);
        return true;
    }
}

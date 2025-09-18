package com.unincor.projetows.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unincor.projetows.model.domain.Endereco;
import com.unincor.projetows.model.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/listar")
    public List<Endereco> Listar() {
        return enderecoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco salvaEndereco(@RequestBody Endereco endereco) {

        var enderecoSalvo = enderecoRepository.save(endereco);
        return enderecoSalvo;
    }

    @DeleteMapping("/{enderecoId}")
    public ResponseEntity<Void> deletarendereco(@PathVariable Integer enderecoId) {
        var endereco = enderecoRepository.findById(enderecoId);
        if (endereco.isPresent()) {
            enderecoRepository.delete(endereco.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}

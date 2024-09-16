package com.escriba.apiregistry.controller;

import com.escriba.apiregistry.model.Atribuicao;
import com.escriba.apiregistry.service.AtribuicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/atribuicoes")
public class AtribuicaoController {
    @Autowired
    private AtribuicaoService atribuicaoService;

    @GetMapping
    public Iterable<Atribuicao> getAllAtribuicoes() {
        return atribuicaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atribuicao> getAtribuicaoById(@PathVariable String id) {
        Optional<Atribuicao> atribuicao = atribuicaoService.findById(id);
        return atribuicao.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Atribuicao createAtribuicao(@Valid @RequestBody Atribuicao atribuicao) {
        return atribuicaoService.save(atribuicao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atribuicao> updateAtribuicao(@PathVariable String id, @Valid @RequestBody Atribuicao atribuicao) {
        return atribuicaoService.findById(id)
                .map(existingAtribuicao -> {
                    atribuicao.setId(id);
                    return ResponseEntity.ok(atribuicaoService.save(atribuicao));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtribuicao(@PathVariable String id) {
        if (atribuicaoService.findById(id).isPresent()) {
            atribuicaoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

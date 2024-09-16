package com.escriba.apiregistry.controller;

import com.escriba.apiregistry.model.Situacao;
import com.escriba.apiregistry.service.SituacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/situacoes")
public class SituacaoController {
    @Autowired
    private SituacaoService situacaoService;

    @GetMapping
    public Iterable<Situacao> getAllSituacoes() {
        return situacaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Situacao> getSituacaoById(@PathVariable String id) {
        Optional<Situacao> situacao = situacaoService.findById(id);
        return situacao.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Situacao createSituacao(@Valid @RequestBody Situacao situacao) {
        return situacaoService.save(situacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Situacao> updateSituacao(@PathVariable String id, @Valid @RequestBody Situacao situacao) {
        return situacaoService.findById(id)
                .map(existingSituacao -> {
                    situacao.setId(id);
                    return ResponseEntity.ok(situacaoService.save(situacao));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSituacao(@PathVariable String id) {
        if (situacaoService.findById(id).isPresent()) {
            situacaoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

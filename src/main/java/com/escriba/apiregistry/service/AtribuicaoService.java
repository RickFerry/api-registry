package com.escriba.apiregistry.service;

import com.escriba.apiregistry.model.Atribuicao;
import com.escriba.apiregistry.repository.AtribuicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AtribuicaoService {
    @Autowired
    private AtribuicaoRepository atribuicaoRepository;

    public Atribuicao save(Atribuicao atribuicao) {
        return atribuicaoRepository.save(atribuicao);
    }

    public Optional<Atribuicao> findById(String id) {
        return atribuicaoRepository.findById(id);
    }

    public Iterable<Atribuicao> findAll() {
        return atribuicaoRepository.findAll();
    }

    public void deleteById(String id) {
        atribuicaoRepository.deleteById(id);
    }
}

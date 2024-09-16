package com.escriba.apiregistry.service;

import com.escriba.apiregistry.model.Situacao;
import com.escriba.apiregistry.repository.SituacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class SituacaoService {
    @Autowired
    private SituacaoRepository situacaoRepository;

    public Situacao save(Situacao situacao) {
        return situacaoRepository.save(situacao);
    }

    public Optional<Situacao> findById(String id) {
        return situacaoRepository.findById(id);
    }

    public Iterable<Situacao> findAll() {
        return situacaoRepository.findAll();
    }

    public void deleteById(String id) {
        situacaoRepository.deleteById(id);
    }
}

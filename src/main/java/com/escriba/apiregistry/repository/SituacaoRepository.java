package com.escriba.apiregistry.repository;

import com.escriba.apiregistry.model.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SituacaoRepository extends JpaRepository<Situacao, String> {
    Optional<Situacao> findByNome(String name);
}

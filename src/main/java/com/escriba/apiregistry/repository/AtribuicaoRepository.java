package com.escriba.apiregistry.repository;

import com.escriba.apiregistry.model.Atribuicao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AtribuicaoRepository extends JpaRepository<Atribuicao, String> {
    Optional<Atribuicao> findByNome(String name);
}

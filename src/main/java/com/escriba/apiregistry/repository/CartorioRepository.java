package com.escriba.apiregistry.repository;

import com.escriba.apiregistry.model.Cartorio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartorioRepository extends JpaRepository<Cartorio, Integer> {
    Optional<Cartorio> findByNome(String name);
}

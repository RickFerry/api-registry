package com.escriba.apiregistry.service;

import com.escriba.apiregistry.model.Cartorio;
import com.escriba.apiregistry.repository.CartorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CartorioService {
    @Autowired
    private CartorioRepository cartorioRepository;

    public Cartorio save(Cartorio cartorio) {
        return cartorioRepository.save(cartorio);
    }

    public Optional<Cartorio> findById(Integer id) {
        return cartorioRepository.findById(id);
    }

    public Iterable<Cartorio> findAll() {
        return cartorioRepository.findAll();
    }

    public void deleteById(Integer id) {
        cartorioRepository.deleteById(id);
    }
}

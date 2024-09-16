package com.escriba.apiregistry.controller;

import com.escriba.apiregistry.model.Cartorio;
import com.escriba.apiregistry.service.CartorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/cartorios")
public class CartorioController {
    @Autowired
    private CartorioService cartorioService;

    @GetMapping
    public Iterable<Cartorio> getAllCartorios() {
        return cartorioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cartorio> getCartorioById(@PathVariable Integer id) {
        Optional<Cartorio> cartorio = cartorioService.findById(id);
        return cartorio.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cartorio createCartorio(@Valid @RequestBody Cartorio cartorio) {
        return cartorioService.save(cartorio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cartorio> updateCartorio(@PathVariable Integer id, @Valid @RequestBody Cartorio cartorio) {
        return cartorioService.findById(id)
                .map(existingCartorio -> {
                    cartorio.setId(id);
                    return ResponseEntity.ok(cartorioService.save(cartorio));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartorio(@PathVariable Integer id) {
        if (cartorioService.findById(id).isPresent()) {
            cartorioService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

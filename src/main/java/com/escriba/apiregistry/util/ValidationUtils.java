package com.escriba.apiregistry.util;

import com.escriba.apiregistry.exception.CustomException;
import com.escriba.apiregistry.repository.AtribuicaoRepository;
import com.escriba.apiregistry.repository.CartorioRepository;
import com.escriba.apiregistry.repository.SituacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidationUtils {

    @Autowired
    private SituacaoRepository situacaoRepository;

    @Autowired
    private AtribuicaoRepository atribuicaoRepository;

    @Autowired
    private CartorioRepository cartorioRepository;

    public void validateUniqueName(String name, String id, String type) {
        boolean isNameTaken = false;
        switch (type) {
            case "situacao":
                isNameTaken = situacaoRepository.findByNome(name).isPresent();
                break;
            case "atribuicao":
                isNameTaken = atribuicaoRepository.findByNome(name).isPresent();
                break;
            case "cartorio":
                isNameTaken = cartorioRepository.findByNome(name).isPresent();
                break;
            default:
                throw new IllegalArgumentException("Tipo inválido para validação de nome");
        }

        if (isNameTaken) {
            String existingId = type.equals("situacao") ? situacaoRepository.findByNome(name).get().getId() :
                    String.valueOf(cartorioRepository.findByNome(name).get().getId());
            if (!existingId.equals(id)) {
                throw new CustomException(String.format("Nome já informado no registro com código %s.", existingId));
            }
        }
    }

    public void validateUniqueId(String id, String type) {
        boolean isIdTaken = false;
        switch (type) {
            case "situacao":
                isIdTaken = situacaoRepository.existsById(id);
                break;
            case "atribuicao":
                isIdTaken = atribuicaoRepository.existsById(id);
                break;
            case "cartorio":
                isIdTaken = cartorioRepository.existsById(Integer.valueOf(id));
                break;
            default:
                throw new IllegalArgumentException("Tipo inválido para validação de ID");
        }

        if (isIdTaken) {
            throw new CustomException("Registro já cadastrado");
        }
    }
}


package com.escriba.apiregistry.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
public class Atribuicao {
    @Id
    @Size(max = 20)
    private String id;

    @NotBlank
    @Size(max = 50)
    private String nome;

    private boolean situacao = true;
}

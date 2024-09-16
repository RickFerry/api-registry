package com.escriba.apiregistry.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Cartorio {
    @Id
    @Min(1)
    private Integer id;

    @NotBlank
    @Size(max = 150)
    private String nome;

    @Size(max = 250)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "situacao_id")
    private Situacao situacao;

    @ManyToMany
    @JoinTable(
            name = "cartorio_atribuicao",
            joinColumns = @JoinColumn(name = "cartorio_id"),
            inverseJoinColumns = @JoinColumn(name = "atribuicao_id"))
    private List<Atribuicao> atribuicoes;
}

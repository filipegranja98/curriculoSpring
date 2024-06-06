package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Curriculo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String endereco;

    @OneToMany(mappedBy = "curriculo", cascade = CascadeType.ALL)
    private List<Formacao> formacoes;

    @OneToMany(mappedBy = "curriculo", cascade = CascadeType.ALL)
    private List<HistoricoProfissional> historicoProfissionals;

}

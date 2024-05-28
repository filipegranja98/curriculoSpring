package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Formacao {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nomeFormacao;

    @Column(nullable = false)
    private String duracao;

    @Column(nullable = false)
    private String instituicao;

    @ManyToOne
    @JoinColumn(name="id_curriculo",referencedColumnName = "id")
    private Curriculo curriculo;

}

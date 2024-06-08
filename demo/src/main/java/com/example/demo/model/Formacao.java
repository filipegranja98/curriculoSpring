package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Curriculo curriculo;

}

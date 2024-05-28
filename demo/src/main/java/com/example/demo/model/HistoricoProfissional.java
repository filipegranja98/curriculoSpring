package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class HistoricoProfissional {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private String empresa;

    @Column(nullable = false)
    private String duracao;

    @ManyToOne
    @JoinColumn(name="id_curriculo",referencedColumnName = "id")
    private Curriculo curriculo;
}

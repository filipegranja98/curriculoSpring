package com.example.demo.repository;

import com.example.demo.model.Formacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FormacaoRepository extends JpaRepository<Formacao, UUID> {
}

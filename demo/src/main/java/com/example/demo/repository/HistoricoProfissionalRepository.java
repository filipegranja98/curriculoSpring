package com.example.demo.repository;

import com.example.demo.model.HistoricoProfissional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface HistoricoProfissionalRepository extends JpaRepository<HistoricoProfissional, UUID> {
}

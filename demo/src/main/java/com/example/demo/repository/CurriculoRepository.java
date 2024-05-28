package com.example.demo.repository;

import com.example.demo.model.Curriculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CurriculoRepository extends JpaRepository<Curriculo, UUID> {
}

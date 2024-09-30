package com.example.ingredientes.repository;

import com.example.ingredientes.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IIngredienteRepository extends JpaRepository<Ingrediente, Long> {
}

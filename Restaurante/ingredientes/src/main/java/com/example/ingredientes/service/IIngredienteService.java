package com.example.ingredientes.service;

import com.example.ingredientes.dto.ListaIngredientesDTO;
import com.example.ingredientes.model.Ingrediente;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IIngredienteService {
    public void saveIngrediente(Ingrediente ingrediente);

    public List<Ingrediente> getAllIngredientes();

    public Ingrediente findIngredienteById(Long id);

    public void deleteIngrediente(Long id);

    public void editIngrediente(Ingrediente ingrediente);

    public ListaIngredientesDTO getAllIngredientesDto();

    public List<Ingrediente> getAllIngredientesPlato(String nombrePlato);
}
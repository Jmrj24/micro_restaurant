package com.example.ingredientes.dto;

import com.example.ingredientes.model.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListaIngredientesDTO {
    private List<Ingrediente> listaIngredientesDto;
}

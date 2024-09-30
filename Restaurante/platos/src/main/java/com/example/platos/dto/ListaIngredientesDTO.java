package com.example.platos.dto;

import com.example.platos.model.Ingrediente;
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

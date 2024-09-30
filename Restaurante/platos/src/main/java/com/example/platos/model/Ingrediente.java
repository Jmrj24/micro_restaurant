package com.example.platos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {
    private Long idIngrediente;
    private String nombreIngrediente;
    private List<String> listaPlatos;
}

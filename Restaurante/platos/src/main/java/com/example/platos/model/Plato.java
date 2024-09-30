package com.example.platos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroPlato;
    private String nombrePlato;
    private double precioPlato;
    private String descripcionPlato;
    @ElementCollection
    private List<String> listaIngredientes;
}

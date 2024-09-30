package com.example.platos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {
    private String nombrePlato;
    private double precioPlato;
    private String descripcionPlato;
}

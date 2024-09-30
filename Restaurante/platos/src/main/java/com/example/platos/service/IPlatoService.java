package com.example.platos.service;

import com.example.platos.dto.PlatoDTO;
import com.example.platos.model.Plato;

import java.util.List;

public interface IPlatoService {
    public void savePlato(PlatoDTO platoDto);

    public List<Plato> getAllPlatos();

    public Plato findPlatoById(Long numeroPlato);

    public void deletePlato(Long numeroPlato);

    public void editPlato(Plato plato);
}

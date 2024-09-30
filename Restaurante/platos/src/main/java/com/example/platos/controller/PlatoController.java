package com.example.platos.controller;

import com.example.platos.dto.PlatoDTO;
import com.example.platos.model.Plato;
import com.example.platos.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plato")
public class PlatoController {
    @Autowired
    private IPlatoService platoServi;

    @PostMapping("/crear")
    public String savePlato(@RequestBody PlatoDTO platoDto) {
        platoServi.savePlato(platoDto);
        return "Plato creado correctamente";
    }

    @GetMapping("/traer")
    public List<Plato> getAllPlatos() {
        return platoServi.getAllPlatos();
    }

    @DeleteMapping("/borrar/{numeroPlato}")
    public String deletePlato(@PathVariable Long numeroPlato) {
        platoServi.deletePlato(numeroPlato);
        return "Plato eliminado correctamente";
    }

    @GetMapping("/traer/{numeroPlato}")
    public Plato findPlato(@PathVariable Long numeroPlato) {
        return platoServi.findPlatoById(numeroPlato);
    }

    @PutMapping("/editar")
    public Plato editPlato(@RequestBody Plato plato) {
        platoServi.editPlato(plato);
        return platoServi.findPlatoById(plato.getNumeroPlato());
    }

}

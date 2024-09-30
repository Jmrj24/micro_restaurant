package com.example.ingredientes.controller;

import com.example.ingredientes.dto.ListaIngredientesDTO;
import com.example.ingredientes.model.Ingrediente;
import com.example.ingredientes.service.IIngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {
    @Autowired
    private IIngredienteService ingredienteServi;

    @PostMapping("/crear")
    public String saveIngrediente(@RequestBody Ingrediente ingrediente) {
        ingredienteServi.saveIngrediente(ingrediente);
        return "Ingrediente creado correctamente";
    }

    @GetMapping("/traer")
    public List<Ingrediente> getAllIngredientes() {
        return ingredienteServi.getAllIngredientes();
    }

    @DeleteMapping("/borrar/{idIngrediente}")
    public String deleteIngrediente(@PathVariable Long idIngrediente) {
        ingredienteServi.deleteIngrediente(idIngrediente);
        return "Ingrediente eliminado correctamente";
    }

    @GetMapping("/traer/{idIngrediente}")
    public Ingrediente findIngrediente(@PathVariable Long idIngrediente) {
        return ingredienteServi.findIngredienteById(idIngrediente);
    }

    @PutMapping("/editar")
    public Ingrediente editIngrediente(@RequestBody Ingrediente ingrediente) {
        ingredienteServi.editIngrediente(ingrediente);
        return ingredienteServi.findIngredienteById(ingrediente.getIdIngrediente());
    }

    @GetMapping("/traer/dto")
    public ListaIngredientesDTO getAllIngredientesDto() {
        return ingredienteServi.getAllIngredientesDto();
    }

    @GetMapping("/traer/plato/{nombrePlato}")
    public List<Ingrediente> getAllIngredientesPlato(@PathVariable String nombrePlato) {
        return ingredienteServi.getAllIngredientesPlato(nombrePlato);
    }
}
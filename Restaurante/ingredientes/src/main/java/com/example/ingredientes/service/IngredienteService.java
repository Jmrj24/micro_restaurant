package com.example.ingredientes.service;

import com.example.ingredientes.dto.ListaIngredientesDTO;
import com.example.ingredientes.model.Ingrediente;
import com.example.ingredientes.repository.IIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredienteService implements IIngredienteService {
    @Autowired
    private IIngredienteRepository ingredienteRepo;

    @Override
    public void saveIngrediente(Ingrediente ingrediente) {
        ingredienteRepo.save(ingrediente);
    }

    @Override
    public List<Ingrediente> getAllIngredientes() {
        return ingredienteRepo.findAll();
    }

    @Override
    public Ingrediente findIngredienteById(Long id) {
        return ingredienteRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteIngrediente(Long id) {
        ingredienteRepo.deleteById(id);
    }

    @Override
    public void editIngrediente(Ingrediente ingrediente) {
        this.saveIngrediente(ingrediente);
    }

    @Override
    public ListaIngredientesDTO getAllIngredientesDto() {
        List<Ingrediente> listaIngredientes = this.getAllIngredientes();
        ListaIngredientesDTO listaIngredientesDTO = new ListaIngredientesDTO();
        listaIngredientesDTO.setListaIngredientesDto(listaIngredientes);
        return listaIngredientesDTO;
    }

    @Override
    public List<Ingrediente> getAllIngredientesPlato(String nombrePlato) {
        List<Ingrediente> listaIngredientes = this.getAllIngredientes();
        List<Ingrediente> listaIngredientesPlato = new ArrayList<Ingrediente>();

        for(Ingrediente ingrediente:listaIngredientes){
            for(String nombre:ingrediente.getListaPlatos()) {
                if(nombre.equals(nombrePlato)) {
                    listaIngredientesPlato.add(ingrediente);
                }
            }
        }

        return listaIngredientesPlato;
    }
}


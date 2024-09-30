package com.example.platos.service;

import com.example.platos.dto.ListaIngredientesDTO;
import com.example.platos.dto.PlatoDTO;
import com.example.platos.model.Ingrediente;
import com.example.platos.model.Plato;
import com.example.platos.repository.IPlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatoService implements IPlatoService {
    @Autowired
    private IPlatoRepository platoRepo;

    @Autowired
    private RestTemplate apiConsumir;

    @Override
    public void savePlato(PlatoDTO platoDto) {
        ListaIngredientesDTO listaIngredientesApi = apiConsumir.getForObject("http://localhost:9002/ingrediente/traer/dto",
                ListaIngredientesDTO.class);

        ArrayList<String> nombresIngredientes = new ArrayList<>();
        if(listaIngredientesApi != null) {
            List<Ingrediente> listaIngredientes = listaIngredientesApi.getListaIngredientesDto();

            Plato plato = new Plato();
            plato.setNombrePlato(platoDto.getNombrePlato());
            plato.setPrecioPlato(platoDto.getPrecioPlato());
            plato.setDescripcionPlato(platoDto.getDescripcionPlato());

            for (Ingrediente ingre : listaIngredientes) {
                for (String nombrePlato : ingre.getListaPlatos()) {
                    if (nombrePlato.equals(platoDto.getNombrePlato())) {
                        nombresIngredientes.add(ingre.getNombreIngrediente());
                    }
                }
            }
            plato.setListaIngredientes(nombresIngredientes);
            platoRepo.save(plato);
        }
    }

    @Override
    public List<Plato> getAllPlatos() {
        return platoRepo.findAll();
    }

    @Override
    public Plato findPlatoById(Long numeroPlato) {
        return platoRepo.findById(numeroPlato).orElse(null);
    }

    @Override
    public void deletePlato(Long numeroPlato) {
        platoRepo.deleteById(numeroPlato);
    }

    @Override
    public void editPlato(Plato plato) {
        platoRepo.save(plato);
    }
}

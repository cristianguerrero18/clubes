package com.example.Clubprueba.Controller;

import com.example.Clubprueba.Entity.Entrenadores;
import com.example.Clubprueba.Repository.EntrenadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EntrenadorController {

    @Autowired
    private EntrenadoresRepository entrenadoresRepository;

    // Mostrar lista de entrenadores
    @GetMapping({"/verEntrenador", "/mostrarentrenador", "/listarentrenador"})
    public String listarEntrenador(Model model) {
        List<Entrenadores> listaEntrenador = entrenadoresRepository.findAll();
        model.addAttribute("listaEntrenador", listaEntrenador);
        return "verEntrenador";
    }

    // Mostrar formulario de nuevo entrenador
    @GetMapping("/verEntrenador/formEntrenador")
    public String mostrarFormulario(Model model) {
        model.addAttribute("entrenador", new Entrenadores());
        return "formEntrenador";
    }

    // Guardar o actualizar entrenador
    @PostMapping("/guardarEntrenador")
    public String guardarEntrenador(Entrenadores entrenador) {
        entrenadoresRepository.save(entrenador);
        return "redirect:/verEntrenador";
    }


    @GetMapping("/verEntrenador/editar/{id}")
    public String editarEntrenador(@PathVariable Long id, Model model) {
        Entrenadores entrenador = entrenadoresRepository.findById(id).orElse(null);
        model.addAttribute("entrenador", entrenador);
        return "formEntrenador";
    }

    @GetMapping("/verEntrenador/eliminar/{id}")
    public String eliminarEntrenador(@PathVariable Long id) {
        entrenadoresRepository.deleteById(id);
        return "redirect:/verEntrenador";
    }
}

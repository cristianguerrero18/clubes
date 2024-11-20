package com.example.Clubprueba.Controller;
import com.example.Clubprueba.Entity.Asociacion;
import com.example.Clubprueba.Entity.Competiciones;
import com.example.Clubprueba.Entity.Entrenadores;
import com.example.Clubprueba.Repository.CompeticionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List ;


@Controller
public class CompeticionesController {

    @Autowired
    private CompeticionRepository competicionRepository ;

    // Mostrar lista de entrenadores
    @GetMapping({"/verCompeticion", "/mostrarcompeticion", "/listarcompeticion"})
    public String listarCompeticion(Model model) {
        List<Competiciones> listaCompeticion = competicionRepository.findAll();
        model.addAttribute("listaCompeticion", listaCompeticion);
        return "verCompeticion";
    }

    // Mostrar formulario de nuevo entrenador
    @GetMapping("/verCompeticion/formCompeticion")
    public String mostrarFormulario(Model model) {
        model.addAttribute("competicion", new Competiciones());
        return "formCompeticion";
    }

    // Guardar o actualizar entrenador
    @PostMapping("/guardarCompeticion")
    public String guardarCompeticion(Competiciones competiciones) {
        competicionRepository.save(competiciones);
        return "redirect:/verCompeticion";
    }

    @GetMapping("/verCompeticion/editar/{id}")
    public String editarCompeticion(@PathVariable Long id, Model model) {
        Competiciones competicion = competicionRepository.findById(id).orElse(null);
        model.addAttribute("competicion", competicion);
        return "formCompeticion";
    }

    @GetMapping("/verCompeticion/eliminar/{id}")
    public String eliminarCompeticion(@PathVariable Long id) {
        competicionRepository.deleteById(id);
        return "redirect:/verCompeticion";
    }
}

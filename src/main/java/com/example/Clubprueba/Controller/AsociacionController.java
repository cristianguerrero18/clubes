package com.example.Clubprueba.Controller;

import com.example.Clubprueba.Entity.Asociacion;
import com.example.Clubprueba.Entity.Entrenadores;
import com.example.Clubprueba.Repository.AsociacionRepository;
import com.example.Clubprueba.Repository.EntrenadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AsociacionController {

    @Autowired
    private AsociacionRepository asociacionRepository;


    @GetMapping({"/verAsociacion", "/mostrarasociacion", "/listarasociacion"})
    public String listarAsociacion(Model model) {
        List<Asociacion> listaAsociacion = asociacionRepository.findAll();
        model.addAttribute("listaAsociacion", listaAsociacion);
        return "verAsociacion";
    }


    @GetMapping("/verAsociacion/formAsociacion")
    public String mostrarFormulario(Model model) {
        model.addAttribute("asociacion", new Asociacion());
        return "formAsociacion";
    }
    @PostMapping("/guardarAsociacion")
    public String guardarAsociacion(Asociacion asociacion) {
        if (asociacion.getId() != null) {

            asociacionRepository.save(asociacion);
        } else {

            asociacionRepository.save(asociacion);
        }
        return "redirect:/verAsociacion";
    }



    @GetMapping("/verAsociacion/editar/{id}")
    public String editarAsociacion(@PathVariable Long id, Model model) {
        Asociacion asociacion = asociacionRepository.findById(id).orElse(null);
        model.addAttribute("asociacion", asociacion);
        return "formAsociacion";
    }


    @GetMapping("/verAsociacion/eliminar/{id}")
    public String eliminarEntrenador(@PathVariable Long id) {
        asociacionRepository.deleteById(id);
        return "redirect:/verAsociacion";
    }
}

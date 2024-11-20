package com.example.Clubprueba.Controller;

import com.example.Clubprueba.Entity.Asociacion;
import com.example.Clubprueba.Entity.Club;
import com.example.Clubprueba.Entity.Jugadores;
import com.example.Clubprueba.Repository.ClubRepository;
import com.example.Clubprueba.Repository.JugadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JugadoresController {

    @Autowired
    private JugadoresRepository jugadoresRepository;

    @Autowired
    private ClubRepository clubRepository;


    @GetMapping({"/verJugador", "/mostrarjugador", "/listarjugar"})
    public String listarJugador(Model model) {
        List<Jugadores> listaJugador = jugadoresRepository.findAll();
        model.addAttribute("listaJugador", listaJugador);
        return "verJugador";
    }


    @GetMapping("/verJugador/formJugador")
    public String mostrarFormulario(Model model) {
        model.addAttribute("jugador", new Jugadores());

        List<Club> listaClubes = clubRepository.findAll();
        model.addAttribute("listaClubes", listaClubes);

        return "formJugador";
    }


    @PostMapping("/guardarJugador")
    public String guardarJugador(Jugadores jugador) {
        if (jugador.getClub() != null) {
            Club club = clubRepository.findById(jugador.getClub().getId()).orElse(null);
            if (club != null) {
                jugador.setClub(club);
                if (!club.getJugadores().contains(jugador)) {
                    club.getJugadores().add(jugador);
                }
            }
        }
        jugadoresRepository.save(jugador);
        return "redirect:/verJugador";
    }


    @GetMapping("/verJugador/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Jugadores jugador = jugadoresRepository.findById(id).orElse(null);
        if (jugador != null) {
            model.addAttribute("jugador", jugador);

            // Obtener lista de clubes
            List<Club> listaClubes = clubRepository.findAll();
            model.addAttribute("listaClubes", listaClubes);

            return "formJugador";
        }
        return "redirect:/verJugador";
    }

    @PostMapping("/guardarEdicionJugador")
    public String guardarEdicionJugador(Jugadores jugador) {
        if (jugador.getClub() != null) {
            Club club = clubRepository.findById(jugador.getClub().getId()).orElse(null);
            if (club != null) {
                jugador.setClub(club);
            }
        }
        jugadoresRepository.save(jugador);
        return "redirect:/verJugador";
    }

    @GetMapping("/verJugador/eliminar/{id}")
    public String eliminarJugador(@PathVariable Long id) {
        jugadoresRepository.deleteById(id);
        return "redirect:/verJugador";
    }
}

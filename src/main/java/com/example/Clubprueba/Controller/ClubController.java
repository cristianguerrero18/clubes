package com.example.Clubprueba.Controller;
import com.example.Clubprueba.Entity.*;
import com.example.Clubprueba.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List ;

@Controller
public class ClubController {

    @Autowired
    private ClubRepository clubRepository ;

    @Autowired
    private AsociacionRepository asociacionRepository  ;

    @Autowired
    private JugadoresRepository jugadoresRepository ;

    @Autowired
    private CompeticionRepository competicionRepository  ;

    @Autowired
    private EntrenadoresRepository entrenadoresRepository  ;

    @GetMapping({"/verClub","mostrarClub","/listarClub"})
    public String listarClub(Model model ){
        List<Club> listaClub  = clubRepository.findAll() ;
        model.addAttribute("listarClub" , listaClub) ;
        return "verClub" ;
    }
    @GetMapping("/verClub/formClub")
    public String mostrarformulario(Model model) {
        model.addAttribute("club", new Club());
        List<Entrenadores> listaEntrenadores = entrenadoresRepository.findAll();
        model.addAttribute("listaEntrenadores", listaEntrenadores);

        List<Jugadores> listaJugadores = jugadoresRepository.findAll();
        model.addAttribute("listaJugadores", listaJugadores);

        List<Asociacion> listaAsociacion = asociacionRepository.findAll();
        model.addAttribute("listaAsociacion", listaAsociacion);

        List<Competiciones> listaCompeticiones = competicionRepository.findAll();
        model.addAttribute("listaCompeticiones", listaCompeticiones);

        return "formClub";  // Este es el nombre de la vista que Spring debe buscar.
    }

    @PostMapping ("/guardarClub")
    public String guardarClub (Club club){
        clubRepository.save(club);
                return "redirect:/verClub";
    }

    @GetMapping("/club/editar/{id}")
    public String modificarClub(@PathVariable("id") Long id, Model model) {
        Club club = clubRepository.findById(id).orElse(null);
        model.addAttribute("club", club);
        model.addAttribute("listaEntrenadores", entrenadoresRepository.findAll());
        model.addAttribute("listaJugadores", jugadoresRepository.findAll());
        model.addAttribute("listaAsociacion", asociacionRepository.findAll());
        model.addAttribute("listaCompeticiones", competicionRepository.findAll());
        return "formClub";
    }

    @GetMapping("/club/eliminar/{id}")
    public String eliminarClub(@PathVariable("id") Long id) {
        clubRepository.deleteById(id);
        return "redirect:/verClub";
    }
    @GetMapping("/club/jugadores/{id}")
    public String listarJugadores(@PathVariable("id") Long id, Model model) {
        Club club = clubRepository.findById(id).orElse(null);
        if (club != null) {
            List<Jugadores> jugadores = jugadoresRepository.findByClubId(id); // Suponiendo que tienes este método en el repositorio
            model.addAttribute("club", club);
            model.addAttribute("jugadores", jugadores);
        } else {
            model.addAttribute("mensaje", "Club no encontrado");
        }
        return "listarJugadores"; // Nombre de la vista que mostrarás
    }

}

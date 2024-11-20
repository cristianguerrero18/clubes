package com.example.Clubprueba.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @NotEmpty
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenadores entrenador;

    @OneToMany
    @JoinColumn(name = "id_club")
    private List<Jugadores> jugadores;

    @ManyToOne
    @JoinColumn(name = "asociacion_id")
    private Asociacion asociacion;

    @ManyToMany
    private List<Competiciones> competiciones;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public @NotEmpty String getNombre() {
        return nombre;
    }

    public void setNombre(@NotEmpty String nombre) {
        this.nombre = nombre;
    }

    public Entrenadores getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenadores entrenador) {
        this.entrenador = entrenador;
    }

    public Asociacion getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(Asociacion asociacion) {
        this.asociacion = asociacion;
    }

    public List<Jugadores> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugadores> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Competiciones> getCompeticiones() {
        return competiciones;
    }

    public void setCompeticiones(List<Competiciones> competiciones) {
        this.competiciones = competiciones;
    }
}

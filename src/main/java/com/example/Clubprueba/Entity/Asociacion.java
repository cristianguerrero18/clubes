package com.example.Clubprueba.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Asociacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String pais;

    @NotEmpty
    private String presidente;

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

    public @NotEmpty String getPais() {
        return pais;
    }

    public void setPais(@NotEmpty String pais) {
        this.pais = pais;
    }

    public @NotEmpty String getPresidente() {
        return presidente;
    }

    public void setPresidente(@NotEmpty String presidente) {
        this.presidente = presidente;
    }
}

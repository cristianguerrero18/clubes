package com.example.Clubprueba.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="entrenadores")
public class Entrenadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Se añade esta línea para generar el ID automáticamente
    @Column(name = "id")
    private Long id;  // Usamos minúscula para seguir la convención de Java

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellido;

    @NotNull
    @Min(18) // Suponiendo que la edad mínima es 18, puedes ajustar esto según sea necesario
    private Integer edad; // Mejor usar Integer en lugar de int para permitir nulls si es necesario

    @NotEmpty
    private String nacionalidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty String getNombre() {
        return nombre;
    }

    public void setNombre(@NotEmpty String nombre) {
        this.nombre = nombre;
    }

    public @NotEmpty String getApellido() {
        return apellido;
    }

    public void setApellido(@NotEmpty String apellido) {
        this.apellido = apellido;
    }

    public @NotNull @Min(18) Integer getEdad() { // Usar Integer y añadir la validación de edad mínima
        return edad;
    }

    public void setEdad(@NotNull @Min(18) Integer edad) { // Cambié int a Integer
        this.edad = edad;
    }

    public @NotEmpty String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(@NotEmpty String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}

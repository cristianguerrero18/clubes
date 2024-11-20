package com.example.Clubprueba.Repository;

import com.example.Clubprueba.Entity.Jugadores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JugadoresRepository extends JpaRepository<Jugadores , Long> {
    List<Jugadores> findByClubId(Long clubId);
}

package com.bosonit.EJERCICIOS.EJ2.infrastructure.repository;

import com.bosonit.EJERCICIOS.EJ2.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface PersonaRepository extends JpaRepository<Persona,Integer> {

    ArrayList<Persona> findByUser(String user);
}

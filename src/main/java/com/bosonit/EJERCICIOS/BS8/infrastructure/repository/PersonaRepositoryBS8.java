package com.bosonit.EJERCICIOS.BS8.infrastructure.repository;

import com.bosonit.EJERCICIOS.BS8.domain.PersonaBS8;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface PersonaRepositoryBS8 extends JpaRepository<PersonaBS8,Integer> {

    ArrayList<PersonaBS8> findByUser(String user);
}

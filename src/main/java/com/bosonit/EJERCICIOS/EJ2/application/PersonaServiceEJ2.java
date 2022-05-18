package com.bosonit.EJERCICIOS.EJ2.application;

import com.bosonit.EJERCICIOS.EJ2.infrastructure.dto.PersonaInputDto;
import com.bosonit.EJERCICIOS.EJ2.infrastructure.dto.PersonaOutputDto;

import java.util.ArrayList;
import java.util.List;

public interface PersonaServiceEJ2 {
    PersonaOutputDto addPersona(PersonaInputDto persona) throws Exception;

    PersonaOutputDto getPersonaById(Integer id) throws Exception;

    ArrayList<PersonaOutputDto> getByUser (String user) throws Exception;

    List<PersonaOutputDto> getAll ();
}

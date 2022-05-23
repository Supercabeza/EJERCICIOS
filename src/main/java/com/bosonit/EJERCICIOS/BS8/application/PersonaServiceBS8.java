package com.bosonit.EJERCICIOS.BS8.application;

import com.bosonit.EJERCICIOS.BS8.domain.PersonaBS8;
import com.bosonit.EJERCICIOS.BS8.infrastructure.dto.PersonaInputDto;
import com.bosonit.EJERCICIOS.BS8.infrastructure.dto.PersonaOutputDto;

import java.util.ArrayList;
import java.util.List;

public interface PersonaServiceBS8 {
    PersonaOutputDto addPersona(PersonaInputDto persona) throws Exception;

    PersonaOutputDto getPersonaById(Integer id) throws Exception;

    ArrayList<PersonaOutputDto> getByUser (String user) throws Exception;

    List<PersonaOutputDto> getAll ();

    String deleteById (Integer id);

    PersonaOutputDto updateById (Integer id, PersonaBS8 personaInputDto);

}

package com.bosonit.EJERCICIOS.BS8.application;


import com.bosonit.EJERCICIOS.BS8.common.exceptions.NotFoundException;
import com.bosonit.EJERCICIOS.BS8.common.exceptions.UnprocesableException;
import com.bosonit.EJERCICIOS.BS8.domain.PersonaBS8;
import com.bosonit.EJERCICIOS.BS8.infrastructure.dto.PersonaInputDto;
import com.bosonit.EJERCICIOS.BS8.infrastructure.dto.PersonaOutputDto;
import com.bosonit.EJERCICIOS.BS8.infrastructure.repository.PersonaRepositoryBS8;
import com.bosonit.EJERCICIOS.EJ2.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceBS8Impl implements PersonaServiceBS8 {

    @Autowired
    PersonaRepositoryBS8 personaRepositoryBS8;


    @Override
    public PersonaOutputDto addPersona(PersonaInputDto personaInputDto) throws UnprocesableException {
        if (personaInputDto.getUser() == null) throw new UnprocesableException("El campo user no puede ser nulo");
        if (personaInputDto.getUser().length()>10) throw new UnprocesableException ("La longitud del campo usuario no puede ser mayor de 10 caracteres");
        PersonaBS8 personaBS8 = new PersonaBS8(personaInputDto);
        personaRepositoryBS8.save(personaBS8);
        PersonaOutputDto personaOutputDTO = new PersonaOutputDto(personaBS8);
        return personaOutputDTO;
    }

    @Override
    public PersonaOutputDto getPersonaById (Integer id) throws NotFoundException {
        PersonaBS8 personaBS8 = personaRepositoryBS8.findById(id).orElseThrow(() -> new NotFoundException ("id no encontrado"));
        return new PersonaOutputDto(personaBS8);
    }

    @Override
    public ArrayList<PersonaOutputDto> getByUser(String user) throws Exception {
        ArrayList<PersonaBS8> listaPersonaBS8s = personaRepositoryBS8.findByUser(user);
        ArrayList<PersonaOutputDto> listaPersonasDtO = new ArrayList<>();
        for (PersonaBS8 p: listaPersonaBS8s) {
            listaPersonasDtO.add (new PersonaOutputDto(p));
        }
        return listaPersonasDtO;
    }

    @Override
    public List<PersonaOutputDto> getAll (){
        List<PersonaBS8> listaPersonaBS8s = personaRepositoryBS8.findAll();
        List<PersonaOutputDto> listaPersonasDto = new ArrayList<>();
        for (PersonaBS8 p: listaPersonaBS8s) {
            listaPersonasDto.add(new PersonaOutputDto(p));
        }
        return listaPersonasDto;
    }

    @Override
    public String deleteById (Integer id){
        PersonaBS8 personaBS8 =  personaRepositoryBS8.findById(id).orElseThrow(()-> new NotFoundException("id no encontrado. " +
                "REGISTRO NO ELIMINADO"));
        personaRepositoryBS8.deleteById(id);
        return "persona con id: " + id + " y user: " + personaBS8.getUser() + "  ELIMINADO";
    }

    @Override
    public PersonaOutputDto updateById (Integer id, PersonaBS8 persona){
        personaRepositoryBS8.findById(id).orElseThrow(()-> new NotFoundException("id no encontrado. " +
                "REGISTRO NO ACTUALIZADO"));

        if (persona.getUser() == null) throw new UnprocesableException("El campo user no puede ser nulo");
        if (persona.getUser().length()>10) throw new UnprocesableException ("La longitud del campo usuario no puede ser mayor de 10 caracteres");

        personaRepositoryBS8.save(persona);
        return new PersonaOutputDto(persona);

    }


}

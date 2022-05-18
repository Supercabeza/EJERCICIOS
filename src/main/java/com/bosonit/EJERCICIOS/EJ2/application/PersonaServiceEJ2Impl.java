package com.bosonit.EJERCICIOS.EJ2.application;


import com.bosonit.EJERCICIOS.EJ2.domain.Persona;
import com.bosonit.EJERCICIOS.EJ2.infrastructure.dto.PersonaInputDto;
import com.bosonit.EJERCICIOS.EJ2.infrastructure.dto.PersonaOutputDto;
import com.bosonit.EJERCICIOS.EJ2.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceEJ2Impl implements PersonaServiceEJ2 {

    @Autowired
    PersonaRepository personaRepository;


    @Override
    public PersonaOutputDto addPersona(PersonaInputDto personaInputDto) throws Exception {
        if (personaInputDto.getUser() ==null) throw new Exception ("El campo user no puede ser nulo");
        if (personaInputDto.getUser().length()>10) throw new Exception ("La longitud del campo usuario no puede ser mayor de 10 caracteres");
        Persona persona = new Persona (personaInputDto);
        personaRepository.save(persona);
        PersonaOutputDto personaOutputDTO = new PersonaOutputDto(persona);
        return personaOutputDTO;
    }

    @Override
    public PersonaOutputDto getPersonaById (Integer id) throws Exception {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new Exception ("id no encontrado"));
        return new PersonaOutputDto(persona);
    }

    @Override
    public ArrayList<PersonaOutputDto> getByUser(String user) throws Exception {
        ArrayList<Persona> listaPersonas = personaRepository.findByUser(user);
        ArrayList<PersonaOutputDto> listaPersonasDtO = new ArrayList<>();
        for (Persona p: listaPersonas) {
            listaPersonasDtO.add (new PersonaOutputDto(p));
        }
        return listaPersonasDtO;
    }

    @Override
    public List<PersonaOutputDto> getAll (){
        List<Persona> listaPersonas = personaRepository.findAll();
        List<PersonaOutputDto> listaPersonasDto = new ArrayList<>();
        for (Persona p: listaPersonas) {
            listaPersonasDto.add(new PersonaOutputDto(p));
        }
        return listaPersonasDto;
    }

}

package com.bosonit.EJERCICIOS.BS8.infrastructure.controller;


import com.bosonit.EJERCICIOS.BS8.application.PersonaServiceBS8;
import com.bosonit.EJERCICIOS.BS8.domain.PersonaBS8;
import com.bosonit.EJERCICIOS.BS8.infrastructure.dto.PersonaInputDto;
import com.bosonit.EJERCICIOS.BS8.infrastructure.dto.PersonaOutputDto;
import com.bosonit.EJERCICIOS.BS8.infrastructure.repository.PersonaRepositoryBS8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/BS8")
public class PersonaControllerBS8 {

    @Autowired
    PersonaRepositoryBS8 personaRepositoryBS8;

    @Autowired
    PersonaServiceBS8 personaServiceBS8;

    //AÑADIR PERSONA CON DATOS EN EL BODY MEDIANTE POSTMAN
    @PostMapping ("addPersona")
    public PersonaOutputDto addPersona (@RequestBody PersonaInputDto persona) throws Exception {
        return personaServiceBS8.addPersona (persona);
    }

    //BUSCAR PERSONA POR EL ID - SI NO ENCUENTRA ID LANZA EXCEPCIÓN
    @GetMapping ("/getPersonaById/{id}")
    public PersonaOutputDto getPersonaPorId (@PathVariable Integer id) throws Exception {
        return personaServiceBS8.getPersonaById (id);
    }

    //BUSCAR PERSONA POR EL CAMPO "user"
    @GetMapping ("/getPersonaByUser/{user}")
    public ArrayList<PersonaOutputDto> getPersonaPorUser (@PathVariable String user) throws Exception {
        return personaServiceBS8.getByUser (user);
    }

    //MOSTRAR TODOS LOS REGISTROS
    @GetMapping ("/getAllPersonas")
    public List<PersonaOutputDto> getAllPersonas (){
        return personaServiceBS8.getAll();
    }

    //BORRAR UN REGISTRO POR ID
    @DeleteMapping("/deletePersonaById/{id}")
    public String deleteById (@PathVariable int id){
        return personaServiceBS8.deleteById(id);
    }


    @PutMapping ("/updatePersonaById/{id}")
    public PersonaOutputDto updatePersonaById (@PathVariable Integer id, @RequestBody PersonaBS8 personaInputDto){
        return personaServiceBS8.updateById(id,personaInputDto);
    }




}

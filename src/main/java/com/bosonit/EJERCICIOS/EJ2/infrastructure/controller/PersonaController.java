package com.bosonit.EJERCICIOS.EJ2.infrastructure.controller;


import com.bosonit.EJERCICIOS.EJ2.application.PersonaServiceEJ2;
import com.bosonit.EJERCICIOS.EJ2.infrastructure.dto.PersonaInputDto;
import com.bosonit.EJERCICIOS.EJ2.infrastructure.dto.PersonaOutputDto;
import com.bosonit.EJERCICIOS.EJ2.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/Ej2")
public class PersonaController {

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    PersonaServiceEJ2 personaServiceEJ2;

    //MANDAR PERSONA CON DATOS EN EL BODY MEDIANTE POSTMAN
    @PostMapping ("addPersona")
    public PersonaOutputDto addPersona (@RequestBody PersonaInputDto persona) throws Exception {
        return personaServiceEJ2.addPersona (persona);
    }

    //BUSCAR PERSONA POR EL ID - SI NO ENCUENTRA ID LANZA EXCEPCIÓN
    @GetMapping ("/getPersonaById/{id}")
    public PersonaOutputDto getPersonaPorId (@PathVariable Integer id) throws Exception {
        return personaServiceEJ2.getPersonaById (id);
    }

    //BUSCAR PERSONA POR EL CAMPO "user"
    @GetMapping ("/getPersonaByUser/{user}")
    public ArrayList<PersonaOutputDto> getPersonaPorUser (@PathVariable String user) throws Exception {
        return personaServiceEJ2.getByUser (user);
    }

    //MOSTRAR TODOS LOS REGISTROS
    @GetMapping ("/getAllPersonas")
    public List<PersonaOutputDto> getAllPersonas (){
        return personaServiceEJ2.getAll();
    }



}

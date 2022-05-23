package com.bosonit.EJERCICIOS.RS1_CRUD.infrastructure.controller;


import com.bosonit.EJERCICIOS.RS1_CRUD.application.PersonaService;
import com.bosonit.EJERCICIOS.RS1_CRUD.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/persona")
public class GetController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/get")
    public ArrayList<Persona> getPersona(){
        return personaService.getPersonas();
    }

    @GetMapping("/get/{id}")
    public Persona getPersona(@PathVariable int id){
        return personaService.getPersonaById(id);
    }

    @GetMapping ("/{id}")
    public Persona getPersonaById (@PathVariable int id){
        return personaService.getPersonaById(id);
    }

    //BUSCA EN EL ARRAYLIST INDEPENDIENTEMENTE DE MAYUSCULAS O MINUSCULAS
    @GetMapping ("/nombre/{nombre}")
    public Persona getPersonaPorNombre (@PathVariable String nombre){
        return personaService.getPersonaByName (nombre);
    }
}

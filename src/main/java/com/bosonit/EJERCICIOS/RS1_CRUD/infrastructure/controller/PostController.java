package com.bosonit.EJERCICIOS.RS1_CRUD.infrastructure.controller;


import com.bosonit.EJERCICIOS.RS1_CRUD.application.PersonaService;
import com.bosonit.EJERCICIOS.RS1_CRUD.domain.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PostController {

    @Autowired
    PersonaService personaService;

    @PostMapping("post")
    public Persona addPersona(@RequestBody Persona p){
        personaService.setPersonas(p);
        return p;
    }
}

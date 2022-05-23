package com.bosonit.EJERCICIOS.RS1_CRUD.infrastructure.controller;




import com.bosonit.EJERCICIOS.RS1_CRUD.application.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class DeleteController {

    @Autowired
    PersonaService personaService;

    @DeleteMapping("/delete/{id}")
    public String deletePersona(@PathVariable int id){
        String respuesta = personaService.deletePersona (id);
        if (respuesta.equals("OK")){
            return "REGISTRO CON ID:" + id + " ELIMINADO";
        }else {
            return "NO SE HA ENCONTRADO EL REGISTRO CON ID:" + id;
        }

    }
}

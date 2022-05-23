package com.bosonit.EJERCICIOS.RS1_CRUD.infrastructure.controller;




import com.bosonit.EJERCICIOS.RS1_CRUD.application.PersonaService;
import com.bosonit.EJERCICIOS.RS1_CRUD.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class PutController {

    @Autowired
    PersonaService personaService;


    /*SEGÚN EL ID QUE ME PASEN EN LA URL, PRIMERO DEBERÍA OBTENER LOS DATOS DE LA PERSONA CON ESE ID
     Y LUEGO SE LO PUEDE PASAR AL MÉTODO updatePersona
    AQUI SE MANDAN TODOS LOS DATOS DE LA PERSONA Y EL METODO updatePersona SE ENCARGARÁ DE ACTUALIZAR
     SOLO LOS CAMPOS QUE CONTENGAN DATOS*/
    @PutMapping("/put/{id}")
    public Persona putPersona(@RequestBody Persona p, @PathVariable int id){
        //Persona personaExistente = personaService.getPersonaForId(id);

        Persona personaNuevosDatos = p;
        return personaService.updatePersona (id, personaNuevosDatos);

    }
}

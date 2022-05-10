package com.bosonit.EJERCICIOS.BS2_0.infrastructure;


import com.bosonit.EJERCICIOS.BS2_0.domain.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ejBS2_0/")
public class Controller2BS2_0 {

    //@Autowired
    Persona persona;

    @GetMapping ("/controlador2/getPersona")
    public int getPersonaX2 (){
        System.out.println(persona.getNombre());
        System.out.println(persona.getCiudad());
        System.out.println(persona.getEdad());

        return persona.getEdad() * 2;

    }




}

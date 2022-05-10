package com.bosonit.EJERCICIOS.BS2_1.infrastructure;

import com.bosonit.EJERCICIOS.BS2_1.application.PersonaServiceBS2_1;
import com.bosonit.EJERCICIOS.BS2_1.domain.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ejBS2_1/controlador2BS2_1")
public class Controller2BS2_1 {


    Persona persona;


    @Autowired
    PersonaServiceBS2_1 personaServiceBS21;


    //COPIA DEL METODO INCLUIDO EN CONTROLADOR1 PARA PROBAR SI FUNCIONA EL METODO QUITANDO EL AUTOWIRED DE Persona persona
    @GetMapping ("/addPersona2")
    public String recibirDatosPersona (@RequestHeader ("nombre") String nombre, @RequestHeader ("ciudad") String ciudad, @RequestHeader ("edad") int edad){
        personaServiceBS21.setNombre(nombre);
        personaServiceBS21.setCiudad (ciudad);
        personaServiceBS21.setEdad (edad);
        //System.out.println(persona);
        System.out.println(personaServiceBS21);

        return "Parámetros recibidos:\n " + nombre + "\n" + ciudad + "\n" + edad;
    }


    //ESTE MÉTODO DEPENDE DEL OTRO.
    @GetMapping ("/getPersona")
    public Persona getPersona2 (){
        Persona per = new Persona("sin nombre", "sin ciudad", 0);
        Persona p;
        if (personaServiceBS21.getPersona() != null){
            p = personaServiceBS21.getPersona();
        } else {
            p = personaServiceBS21.addPersona(per.getNombre(),per.getCiudad(),per.getEdad());
        }

        //System.out.println(personaService.getPersona());
        p.setEdad(p.getEdad() * 2);
        return personaServiceBS21.getPersona();
    }


}

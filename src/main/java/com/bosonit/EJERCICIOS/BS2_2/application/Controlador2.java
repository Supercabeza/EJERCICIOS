package com.bosonit.EJERCICIOS.BS2_2.application;



import com.bosonit.EJERCICIOS.BS2_2.domain.Ciudad;
import com.bosonit.EJERCICIOS.BS2_2.domain.Persona;
import com.bosonit.EJERCICIOS.BS2_2.infrastructure.CiudadService;
import com.bosonit.EJERCICIOS.BS2_2.infrastructure.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controlador2 {


    Persona persona;




    @Autowired
    PersonaService personaService;

    @Autowired
    CiudadService ciudadService;

    //COPIA DEL METODO INCLUIDO EN CONTROLADOR1 PARA PROBAR SI FUNCIONA EL METODO QUITANDO EL AUTOWIRED DE Persona persona
    @GetMapping ("/controlador2/addPersona2")
    public String recibirDatosPersona (@RequestHeader ("nombre") String nombre, @RequestHeader ("ciudad") String ciudad, @RequestHeader ("edad") int edad){
        personaService.setNombre(nombre);
        personaService.setCiudad (ciudad);
        personaService.setEdad (edad);
        //System.out.println(persona);
        System.out.println(personaService);

        return "Parámetros recibidos:\n " + nombre + "\n" + ciudad + "\n" + edad;
    }


    //ESTE MÉTODO DEPENDE DEL OTRO. ESTE ME DA NULL SI NO HAGO ANTES EL GET DEL CONTROLADOR1
    @GetMapping ("/controlador2/getPersona")
    public Persona getPersona2 (){
        Persona per = new Persona("sin nombre", "sin ciudad", 0);
        Persona p;
        if (personaService.getPersona() != null){
            p = personaService.getPersona();
        } else {
            p = personaService.addPersona(per.getNombre(),per.getCiudad(),per.getEdad());
        }

        //System.out.println(personaService.getPersona());
        p.setEdad(p.getEdad() * 2);
        return personaService.getPersona();
    }

    @GetMapping ("/controlador2/getCiudad")
    public ArrayList<Ciudad> getCiudad (){
        ArrayList<Ciudad> listaCiudades = new ArrayList<>();
        listaCiudades = ciudadService.getListaCiudades();
        return listaCiudades;
    }


}

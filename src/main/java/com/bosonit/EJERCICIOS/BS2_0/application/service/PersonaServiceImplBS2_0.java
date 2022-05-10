package com.bosonit.EJERCICIOS.BS2_0.application.service;


import com.bosonit.EJERCICIOS.BS2_0.domain.Persona;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImplBS2_0 implements PersonaService{

    //@Autowired
    Persona persona = new Persona ();


    @Override
    public String getNombre() {
        return null;
    }

    @Override
    public void setNombre(String nombre) {
        persona.setNombre(nombre);
    }

    @Override
    public int getEdad() {
        return 0;
    }

    @Override
    public void setEdad(int edad) {
        persona.setEdad(edad);
    }

    @Override
    public String getCiudad() {
        return null;
    }

    @Override
    public void setCiudad(String ciudad) {
        persona.setCiudad(ciudad);
    }
}

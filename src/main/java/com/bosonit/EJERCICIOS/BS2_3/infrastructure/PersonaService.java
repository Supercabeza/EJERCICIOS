package com.bosonit.EJERCICIOS.BS2_3.infrastructure;


import com.bosonit.EJERCICIOS.BS2_3.domain.Persona;
import org.springframework.context.annotation.Bean;


public class PersonaService {


    Persona persona;


    public Persona addPersona (String nombre, String ciudad, int edad ) {
        Persona p = new Persona(nombre, ciudad, edad);
        persona = p;
        return persona;
    }


    public Persona getPersona (){
        return persona;
    }

    public String getNombre() {
        return persona.getNombre();
    }


    public void setNombre(String nombre) {
        persona.setNombre(nombre);
    }


    public int getEdad() {
        return persona.getEdad();
    }


    public void setEdad(int edad) {
        persona.setEdad(edad);
    }


    public String getCiudad() {
        return persona.getCiudad();
    }


    public void setCiudad(String ciudad) {
        persona.setCiudad(ciudad);
    }


    @Bean("personaBean1")
    public Persona personaBean1 (Persona p){
        p.setNombre("bean1");
        return p;
    }

    @Bean ("personaBean2")
    public Persona personaBean2 (Persona p){
        p.setNombre("bean2");
        return p;
    }

    @Bean ("personaBean3")
    public Persona personaBean3 (Persona p){
        p.setNombre("bean3");
        return p;
    }
}

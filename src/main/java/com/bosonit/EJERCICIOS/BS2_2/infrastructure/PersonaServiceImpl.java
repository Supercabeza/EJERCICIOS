package com.bosonit.EJERCICIOS.BS2_2.infrastructure;



import com.bosonit.EJERCICIOS.BS2_2.domain.Persona;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService{


    Persona persona;

    @Override
    public Persona addPersona (String nombre, String ciudad, int edad ) {
        Persona p = new Persona(nombre, ciudad, edad);
        persona = p;
        return persona;
    }

    // TODO ESTE MÉTODO ESTÁ BIEN ??
    @Override
    public Persona getPersona (){
        return persona;

    }



    @Override
    public String getNombre() {
        return persona.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        persona.setNombre(nombre);
    }

    @Override
    public int getEdad() {
        return persona.getEdad();
    }

    @Override
    public void setEdad(int edad) {
        persona.setEdad(edad);
    }

    @Override
    public String getCiudad() {
        return persona.getCiudad();
    }

    @Override
    public void setCiudad(String ciudad) {
        persona.setCiudad(ciudad);
    }
}

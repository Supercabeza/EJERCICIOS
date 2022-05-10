package com.bosonit.EJERCICIOS.BS2_2.infrastructure;


import com.bosonit.EJERCICIOS.BS2_2.domain.Persona;

public interface PersonaService {


    public Persona addPersona (String nombre, String ciudad, int edad);

    public Persona getPersona ();

    public String getNombre ();
    public void setNombre (String nombre);

    public int getEdad ();
    public void setEdad (int edad);

    public String getCiudad ();
    public void setCiudad (String ciudad);
}

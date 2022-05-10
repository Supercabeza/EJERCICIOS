package com.bosonit.EJERCICIOS.BS2_0.domain;

//@Service
public class Persona {
    String nombre;
    String ciudad;
    int edad;




    /*public Persona (String nombre, String ciudad, int edad ){
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.edad = edad;
    }

*/
    public Persona (){
        nombre = "Nombre por defecto";
        edad = 40;
        ciudad = "Ciudad por defecto";
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "-" + " Ciudad: " + ciudad + "-" + "Edad: " + edad;
    }
}

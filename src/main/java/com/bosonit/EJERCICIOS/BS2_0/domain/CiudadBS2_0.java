package com.bosonit.EJERCICIOS.BS2_0.domain;

import org.springframework.stereotype.Service;

@Service
public class CiudadBS2_0 {

    private String nombre;
    private int numeroHabitantes;



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroHabitantes() {
        return numeroHabitantes;
    }

    public void setNumeroHabitantes(int numeroHabitantes) {
        this.numeroHabitantes = numeroHabitantes;
    }
}

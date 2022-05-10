package com.bosonit.EJERCICIOS.RS1_CRUD.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {

    private String nombre;
    private int edad;
    private String poblacion;
    private int id;
}

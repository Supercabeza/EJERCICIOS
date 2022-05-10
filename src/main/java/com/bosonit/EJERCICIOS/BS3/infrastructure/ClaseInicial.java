package com.bosonit.EJERCICIOS.BS3.infrastructure;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ClaseInicial {


    @PostConstruct
    public void metodo1(){
        //System.out.println("post Construct");
        System.out.println("EJERCICIO BS3: Hola desde clase inicial");
    }

}

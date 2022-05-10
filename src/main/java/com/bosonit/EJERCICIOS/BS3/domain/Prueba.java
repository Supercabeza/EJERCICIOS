package com.bosonit.EJERCICIOS.BS3.domain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Prueba {

    @Bean
    CommandLineRunner metodoClaseModel1(){
        return p->{
            System.out.println("EJERCICIO BS3: Soy la tercera clase");
        };
    }
}

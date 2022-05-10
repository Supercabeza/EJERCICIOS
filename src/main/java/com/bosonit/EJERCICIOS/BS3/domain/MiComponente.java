package com.bosonit.EJERCICIOS.BS3.domain;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MiComponente {



    @Bean
    public CommandLineRunner metodoClaseComponente(){
        return p->{
            //System.out.println("Mensaje de prueba desde clase Componente");
        };
    }
}

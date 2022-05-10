package com.bosonit.EJERCICIOS.BS3.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class Controller1 implements CommandLineRunner {

    @Bean
    public CommandLineRunner metodoController1(){
        return p->{
            //QUITAR LOS COMENTARIOS PARA VER CUANDO SE EJECUTA LA SIGUIENTE LINEA
            //System.out.println("Esto se ejecuta después del método run de la clase que implemente a CommandLineRunner");
        };
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("EJERCICIO BS3: Hola desde clase secundaria");
        System.out.println(Arrays.toString(args));
    }
}

package com.bosonit.EJERCICIOS.BS4_1.application;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@PropertySource("classpath:/miconfiguracion.properties")
@RestController
public class MiConfiguracion implements CommandLineRunner {

    @Value("${valor1}")
    private String valor1;

    @Value("${valor2}")
    private String valor2;

    public void run (String... args) throws Exception {
        System.out.println("Valor1: " + valor1 + " - Valor2: " + valor2 );
    }

    @GetMapping("/miconfiguracion")
    public String getValores(){
        return "Valor1: " + valor1 + "\nValor2: " + valor2;
    }
}

package com.bosonit.EJERCICIOS.BS4_1.domain;



import com.bosonit.EJERCICIOS.BS4_1.infrastructure.Perfiles;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "Perfil1")
public class Perfil1 implements Perfiles {

    @Value("${perfil1}")
    private String perfil = "Perfil1";

    public String getPerfil1(){
        return perfil;
    }

    @Override
    public String miFuncion() {
        return "Perfil seleccionado : " + perfil ;
    }

}

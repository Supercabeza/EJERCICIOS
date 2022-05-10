package com.bosonit.EJERCICIOS.BS4_1.domain;



import com.bosonit.EJERCICIOS.BS4_1.infrastructure.Perfiles;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "Perfil2")
public class Perfil2 implements Perfiles {

    @Value("${perfil2}")
    private String perfil = "Perfil2";

    public String getPerfil2(){
        return perfil;
    }

    @Override
    public String miFuncion() {
        return "Perfil seleccionado : " + perfil;

    }

}

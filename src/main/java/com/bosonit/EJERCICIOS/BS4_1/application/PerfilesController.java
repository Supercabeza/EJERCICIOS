package com.bosonit.EJERCICIOS.BS4_1.application;


import com.bosonit.EJERCICIOS.BS4_1.infrastructure.Perfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/EJBS4_1")
@Configuration
public class PerfilesController  {

    @Value("${url}")
    private String url;

    @Value("${password}")
    private String password;

    @Autowired
    Perfiles perfiles;





    @Value("${PRUEBA_INTELLIJ}") //METE EN var3 EL CONTENIDO DE LA VARIABLE PRUEBA_INTELLIJ (DEFINIDA EN EL S.O.)
    private String var3;

    @Value("${PROOF:valor contenido por defecto}") //METE EN var4 EL CONTENIDO DE LA VARIABLE PROOF DEFINIDA
    private String var4;                            // EN EL application.properties

    @GetMapping("/var3")
    public String getVar3(){
        return "VAR3: " + var3;
    }

    @GetMapping("/var4")
    public String getVar4(){
        return "VAR4: " + var4;
    }



    @GetMapping ("/perfil")
    public String conocerPerfilActivo (){
        return perfiles.miFuncion();
    }


    @GetMapping ("parametros")
    public String getParametros(){
        return "url: "+url+"\nPassword: "+password;
    }



}

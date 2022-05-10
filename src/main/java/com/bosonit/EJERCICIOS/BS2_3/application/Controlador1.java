package com.bosonit.EJERCICIOS.BS2_3.application;



import com.bosonit.EJERCICIOS.BS2_3.domain.Persona;
import com.bosonit.EJERCICIOS.BS2_3.infrastructure.PersonaService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/ej2/bean")
public class Controlador1 {

    PersonaService personaService = new PersonaService();

    @Qualifier ("personaBean1")
    @PostMapping ("/bean1")
    public Persona nombreBean1 (@RequestBody Persona per){
        return personaService.personaBean1(per);
    }

    @Qualifier ("personaBean2")
    @PostMapping ("/bean2")
    public Persona nombreBean2 (@RequestBody Persona per){
        return personaService.personaBean2(per);
    }

    @Qualifier ("personaBean3")
    @PostMapping ("/bean3")
    public Persona nombreBean3 (@RequestBody Persona per){
        return personaService.personaBean3(per);
    }





}


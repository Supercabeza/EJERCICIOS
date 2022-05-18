package com.bosonit.EJERCICIOS.EJ2.infrastructure.dto;


import com.bosonit.EJERCICIOS.EJ2.domain.Persona;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PersonaOutputDto {


    private Integer id;

    private String user;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String image_url;
    private Date termination_date;


    public PersonaOutputDto (Persona persona){
        id = persona.getId();
        user = persona.getUser();
        password = persona.getPassword();
        name = persona.getName();
        surname = persona.getSurname();
        company_email = persona.getCompany_email();
        personal_email = persona.getPersonal_email();
        city = persona.getCity();
        active = persona.isActive();
        created_date = persona.getCreated_date();
        image_url = persona.getImage_url();
        termination_date = persona.getTermination_date();
    }

}

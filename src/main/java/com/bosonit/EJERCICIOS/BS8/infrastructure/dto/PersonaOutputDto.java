package com.bosonit.EJERCICIOS.BS8.infrastructure.dto;


import com.bosonit.EJERCICIOS.BS8.domain.PersonaBS8;
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


    public PersonaOutputDto (PersonaBS8 personaBS8){
        id = personaBS8.getId();
        user = personaBS8.getUser();
        password = personaBS8.getPassword();
        name = personaBS8.getName();
        surname = personaBS8.getSurname();
        company_email = personaBS8.getCompany_email();
        personal_email = personaBS8.getPersonal_email();
        city = personaBS8.getCity();
        active = personaBS8.isActive();
        created_date = personaBS8.getCreated_date();
        image_url = personaBS8.getImage_url();
        termination_date = personaBS8.getTermination_date();
    }

}

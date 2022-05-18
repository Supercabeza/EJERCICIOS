package com.bosonit.EJERCICIOS.EJ2.domain;




import com.bosonit.EJERCICIOS.EJ2.infrastructure.dto.PersonaInputDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Persona {


    @Id
    @GeneratedValue
    //@Column(name = "Id")
    private Integer Id;
    //@Column(name = "user")
    private String user;
    //@Column(name = "password")
    private String password;
    //@Column (name = "name")
    private String name;
    //@Column(name = "surname")
    private String surname;

    @Column(name = "EmailCompañia")
    private String company_email;

    //@Column(name = "personal_email")
    private String personal_email;

    //@Column(name = "city")
    private String city;
    //@Column(name = "active")
    private boolean active;
    //@Column(name = "created_date")
    private Date created_date;
    //@Column(name = "image_url")
    private String image_url;
    //@Column(name = "termination_date")
    private Date termination_date;

    //TODO - PROBAR A QUITAR EL @COLUM DE LOS CAMPOS MARCADOS CON @ENTITY A VER SI FUNCIONA TODA ESTA PARAFERNALIA

    public Persona (PersonaInputDto persona){

        user = persona.getUser();
        password = persona.getPassword();
        name = persona.getName();
        surname = persona.getSurname();
        company_email = persona.getCompany_email();
        personal_email= persona.getPersonal_email();
        city = persona.getCity();
        active = persona.isActive();
        created_date = persona.getCreated_date();
        image_url = persona.getImage_url();
        termination_date = persona.getTermination_date();
    }

}

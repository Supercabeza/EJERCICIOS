package com.bosonit.EJERCICIOS.RS1_CRUD.application;



import com.bosonit.EJERCICIOS.RS1_CRUD.domain.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonaService {

    ArrayList<Persona> personas = new ArrayList<>();
    Persona persona;

    //AÑADIR UNA PERSONA A LA LISTA
    public ArrayList<Persona> setPersonas(Persona p){
        personas.add(p);
        return personas;
    }

    //MODIFICAR UNA PERSONA DE LA LISTA
    public Persona updatePersona (int id, Persona personaNuevosDatos){
        String nombre = personaNuevosDatos.getNombre();
        int edad = personaNuevosDatos.getEdad();
        String poblacion = personaNuevosDatos.getPoblacion();

        Persona personaConDatosCambiados = new Persona("Nombre no modificado", -3, "Población no modificada", -3);
        Persona personaACambiar;
        personaACambiar = getPersonaById(id);

        //SOLO UTILIZO LOS CAMPOS QUE CONTENGAN DATOS
        if (nombre.length()!=0)
            personaACambiar.setNombre (nombre);
        if (edad > 0)
            personaACambiar.setEdad(edad);
        if (poblacion.length()!=0)
            personaACambiar.setPoblacion(poblacion);

        //EN ESTE PUNTO, personaACambiar DEBE CONTENER LO QUE ME INTERESA
        //ENTONCES AHORA TOCA MODIFICAR EN LA LISTA LOS DATOS DE ESA PERSONA POR EL ID

        for (Persona per : personas ) {
            if (per.getId() == id){
                per.setNombre(personaACambiar.getNombre());
                per.setEdad(personaACambiar.getEdad());
                per.setPoblacion(personaACambiar.getPoblacion());
                personaConDatosCambiados = per;
            }
        }


       return personaConDatosCambiados;


    }

    //BORRAR UNA PERSONA DE LA LISTA A RAIZ DEL ID
    //QUE HACE EL MÉTODO ?: BUSCA EL ID EN EL ARRAYLIST. EL QUE COINCIDA SE ELIMINARÁ
    public String deletePersona (int id){
        Persona person = getPersonaById(id);
        if (person.getNombre().equals("NO EXISTE"))  {
            return "NO SE HA ENCONTRADO PERSONA CON ID:" + id + ".";
        }else{
            for (Persona per : personas ) {
                if (per.getId() == id) {
                    personas.remove(per);
                    return "OK";
                }
            }

        }

        return "NO";






        /*for(int i =0; i<personas.size();i++){
            if(personas.get(i).getId()==id){
                personas.remove(i);
                return personas;
            }
        }
        return personas;*/
    }

    //OBTENER LA LA LISTA COMPLETA DE PERSONAS
    public ArrayList<Persona> getPersonas(){
        return personas;
    }

    //OBTENER PERSONA POR ID

    public Persona getPersonaById(int id){
        Persona p = new Persona("NO EXISTE",0,"NO EXISTE", 0);
        for (Persona per: personas) {
            if (per.getId() == id){
                p.setNombre (per.getNombre());
                p.setEdad (per.getEdad());
                p.setPoblacion (per.getPoblacion());
                p.setId(id);
            }
        }

        return p; //DEVUELVO LA PERSONA CUYO ID ME HAN PASADO POR PARÁMETRO

    }


    //ESTE METODO BUSCA EN EN ARRAYLIST, Y LO HACE INDEPENDIENTEMENTE DE LAS MAYÚSCULAS O MINÚSCULAS
    public Persona getPersonaByName(String nombre) {
        Persona p = new Persona("NO EXISTE",0,"NO EXISTE", 0);
        for (Persona per: personas){
            if (per.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                System.out.println("Persona encontrada: ");
                System.out.println(per.getNombre());
                System.out.println(per.getEdad());
                System.out.println(per.getPoblacion());
                return per;
            }
        }
        return p;
    }
}

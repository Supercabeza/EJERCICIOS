package com.bosonit.EJERCICIOS.BS2_1.infrastructure;


import com.bosonit.EJERCICIOS.BS2_1.application.PersonaServiceBS2_1;
import com.bosonit.EJERCICIOS.BS2_1.domain.Ciudad;
import com.bosonit.EJERCICIOS.BS2_1.domain.Greeting;
import com.bosonit.EJERCICIOS.BS2_1.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/ejBS2_1/controlador1BS2_1")
public class Controller1BS2_1 {

    //@Autowired
    private ArrayList<Ciudad> listaCiudades = new ArrayList<>();

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonaServiceBS2_1 personaServiceBS21;


    @GetMapping("/greeting")
    public Greeting getHola (@RequestParam(value="name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }

    @GetMapping("/api/employees/{id}")
    public String getId (@PathVariable String id){
        return "id del empleado " + id;
    }

    //path variable
    @GetMapping("/api/employeeswithvariable/{id}")
    public String getEmployeesByIdWithVariableName(@PathVariable("id") String employeeId) {
        return "ID: " + employeeId;
    }

    //PATH VARIABLE CON VALUE (IGUAL QUE LA ANTERIOR PERO CON VALUE)
    @GetMapping("/api/employeeswithvariable2/{id}")
    public String getEmployeesByIdWithVariableName2(@PathVariable(value = "id") String employeeId) {
        return "ID: " + employeeId;
    }

    //PATH VARIABLE CON 2 VARIABLES COMO PARÁMETRO
    // PARA PROBARLO HAY QUE ESCRIBIR ESTO EN EL NAVEGADOR O EN POSTMAN:
    // localhost:8080/api/employees/21/Pedro
    // la salida debe ser esta:
    // Id: 21 - Name: Pedro
    @GetMapping ("/api/employees/{id}/{name}")
    public String getEmployeesTwoVariables (@PathVariable String id, @PathVariable String name){
        return "Id: " + id + " - " + "Name: " + name;
    }

    @GetMapping("/api/employeeswithmapvariable/{id}/{name}")
    @ResponseBody
    public String getEmployeesByIdAndNameWithMapVariable(@PathVariable Map<String, String> pathVarsMap) {
        String id = pathVarsMap.get("id");
        String name = pathVarsMap.get("name");
        if (id != null && name != null) {
            return "ID: " + id + ", name: " + name;
        } else {
            return "Missing Parameters";
        }
    }

    //TAL Y COMO ESTÁ ESTE MÉTODO, SI NO LE METES EL ID, LA SALIDA DA ERROR
    @GetMapping(value = { "/api/employeeswithrequired", "/api/employeeswithrequired/{id}" })
    @ResponseBody
    public String getEmployeesByIdWithRequired(@PathVariable String id) {
        return "ID: " + id;
    }


    //EN ESTE METODO NO HACE FALTA METER EL ID, GRACIAS A LA CLAUSULA required = false
    @GetMapping(value = { "/api/employeeswithrequiredfalse", "/api/employeeswithrequiredfalse/{id}" })
    @ResponseBody
    public String getEmployeesByIdWithRequiredFalse(@PathVariable(required = false) String id) {
        if (id != null) {
            return "ID: " + id;
        } else {
            return "ID missing";
        }
    }

    //MÉTODO IDEM AL ANTERIOR, PERO CON OPTIONAL. SI NO LE METES ID, NO PASA NADA MALO. SACA EL MENSAJE DE ERROR
    // EL OPTIONAL TIENE EL METODO isPresent, CON EL QUE PUEDO SABER SI TIENE UN VALOR NULO
    @GetMapping(value = { "/api/employeeswithoptional", "/api/employeeswithoptional/{id}" })
    @ResponseBody
    public String getEmployeesByIdWithOptional(@PathVariable Optional<String> id) {
        if (id.isPresent()) {
            return "ID: " + id.get();
        } else {
            return "ID missing";
        }
    }

    //MÉTODO IDEM AL ANTERIOR, PERO CON OPTIONAL. SI NO LE METES ID, NO PASA NADA MALO. SACA EL MENSAJE DE ERROR
    // EL OPTIONAL TIENE EL METODO isPresent, CON EL QUE PUEDO SABER SI TIENE UN VALOR NULO
    //NO PUEDO DEJAR LOS 2 ACTIVOS PORQUE TIENEN EL MISMO MAPPING
    /*@GetMapping(value = { "/api/employeeswithoptional", "/api/employeeswithoptional/{id}" })
    @ResponseBody
    public String getEmployeesByIdWithOptionalLambda(@PathVariable Optional<String> id) {
        return id.map(s -> "ID: " + s).orElse("ID missing");
    }
*/

    //FUNCIONA
    //EJERCICIO TIPO GET DEL DOCUMENTO PLAN ESTUDIOS JAVA -  PAGINA 11
    //DEVUELVE UN STRING PONIENDO "HOLA" + EL CONTENIDO DE LA VARIABLE NOMBRE
    @GetMapping ("/user/{name}")
    public String getUser (@PathVariable String name){
        return "Hola " + name;
    }

    //FUNCIONA
    //EJERCICIO TIPO POST DEL DOCUMENTO PLAN ESTUDIOS JAVA - PAGINA 11
    // LE MANDAS UN OBJETO DE TIPO PERSONA Y TE DEVUELVE LA EDAD + 1
    @PostMapping(path = "/useradd")
    public Persona getPersons (@RequestBody Persona persona) throws IOException {
        persona.setEdad(persona.getEdad()+1);
        return persona;
    }


    
    @PostMapping ("/useraddPrueba")
    public String getUser2 (@RequestParam String name){
        return "Hola " + name;
    }



    @PostMapping("/persons2")
    public Persona getPersons2 (@RequestParam Persona persona) throws IOException {
        persona.setEdad(persona.getEdad()+500);
        return persona;
    }


    @GetMapping ("/addPerson00")
    public String recibirDatosPersona2 (@RequestHeader ("prueba01") String token1){
        return "Esto es una prueba: Se recibe la cadena: " + token1;

    }

    @GetMapping ("/addPersona01")
    public String recibirDatosPersonaXX (@RequestHeader ("nombre") String nombre, @RequestHeader ("ciudad") String ciudad, @RequestHeader ("edad") int edad){
        return "Datos de la persona:\n Nombre: " + nombre + ", " + " Población: " + ciudad + ", " + "Edad: " + edad;
    }

/*

    @GetMapping ("/addPersona001")
    public String recibirDatosPersona001 (@RequestHeader ("nombre") String nombre, @RequestHeader ("ciudad") String ciudad, @RequestHeader ("edad") int edad){
        personaServiceBS21.setNombre(nombre);
        personaServiceBS21.setCiudad (ciudad);
        personaServiceBS21.setEdad (edad);

        return "Parámetros recibidos:\n " + nombre + "\n" + ciudad + "\n" + edad;
    }
*/


    //EJERCICIO BS1: CON UN ENDPOINT TIPO GET, MANDAR CON POSTMAN CON HEADERS, LOS DATOS DE LA PERSONA
    @GetMapping ("/addPersona")
    public Persona recibirDatosPersona (@RequestHeader ("nombre") String nombre, @RequestHeader ("ciudad") String ciudad, @RequestHeader ("edad") int edad){
        Persona p = personaServiceBS21.addPersona(nombre,ciudad, edad);
        return p;
        //ESTAS 2 LINEAS SERÍAN IGUAL A ESTA
        // return personaService.addPersona (nombre, ciudad, edad);
    }
/*
    @PostMapping ("/controlador1/addCiudad")
    public void agregarCiudad (@RequestHeader ("nombreCiudad") String nombreCiudad, @RequestHeader ("numeroHabitantes") int numeroHabitantes){
        Ciudad ciudad = personaService.addCiudad(nombreCiudad, numeroHabitantes);
        listaCiudades.add(ciudad);
        return ciudad;
    }*/


}

package com.bosonit.EJERCICIOS.BS2_2.application;


import com.bosonit.EJERCICIOS.BS2_2.domain.Ciudad;
import com.bosonit.EJERCICIOS.BS2_2.domain.Greeting;
import com.bosonit.EJERCICIOS.BS2_2.domain.Persona;
import com.bosonit.EJERCICIOS.BS2_2.infrastructure.CiudadService;
import com.bosonit.EJERCICIOS.BS2_2.infrastructure.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping ("/ej2_2")
public class ControladorBS2_2 {

    @Autowired
    PersonaService personaService;

    @Autowired
    CiudadService ciudadService;

    private ArrayList<Ciudad> listaCiudades = new ArrayList<>();

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();





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


    @GetMapping ("/controlador1/addPerson00")
    public String recibirDatosPersona2 (@RequestHeader ("prueba01") String token1){
        return "Esto es una prueba: Se recibe la cadena: " + token1;

    }

    @GetMapping ("/controlador1/addPersona01")
    public String recibirDatosPersonaXX (@RequestHeader ("nombre") String nombre, @RequestHeader ("ciudad") String ciudad, @RequestHeader ("edad") int edad){
        return "Datos de la persona:\n Nombre: " + nombre + ", " + " Población: " + ciudad + ", " + "Edad: " + edad;
    }


    @GetMapping ("/controlador1/addPersona001")
    public String recibirDatosPersona001 (@RequestHeader ("nombre") String nombre, @RequestHeader ("ciudad") String ciudad, @RequestHeader ("edad") int edad){
        personaService.setNombre(nombre);
        personaService.setCiudad (ciudad);
        personaService.setEdad (edad);

        return "Parámetros recibidos:\n " + nombre + "\n" + ciudad + "\n" + edad;
    }


    //EJERCICIO BS2-1: MANDAR CON POSTMAN EN LOS HEADERS, LOS DATOS DE LA PERSONA
    @GetMapping ("/controlador1/addPersona")
    public Persona recibirDatosPersona (@RequestHeader ("nombre") String nombre, @RequestHeader ("ciudad") String ciudad, @RequestHeader ("edad") int edad){
        Persona p = personaService.addPersona(nombre,ciudad, edad);
        return p;
        //ESTAS 2 LINEAS SERÍAN IGUAL A ESTA
        // return personaService.addPersona (nombre, ciudad, edad);
    }

    //EJERCICIO BS2-2: MANDAR TIPO POST, NOMBRE CIUDAD Y NUMHABITANTES
    @GetMapping ("/controlador1/addCiudad2")
    public Ciudad addCiudad2 (@RequestHeader ("nombreCiudad") String nombreCiudad, @RequestHeader ("numHabitantes") int numHabitantes){
        Ciudad ciudad = ciudadService.addCiudad(nombreCiudad, numHabitantes);
        return ciudad;
    }

    @PostMapping ("/controlador1/addCiudad3/{nombreCiuda}/{numHabitantes}")
    public Ciudad addCiudad3 (@RequestParam ("nombreCiudad") String nombreCiudad, @RequestParam ("numHabitantes") int numHabitantes){
        Ciudad ciudad = ciudadService.addCiudad(nombreCiudad, numHabitantes);
        return ciudad;
    }

/*

    @PostMapping ("/controlador1/addCiudad/{nombreCiudad}/{numHabitantes}")
    public ArrayList<Ciudad> addCiudadAListaCiudades (@RequestParam ("nombreCiudad") String nombreCiudad, @RequestParam ("numHabitantes") int numHabitantes){
        Ciudad ciudad = ciudadService.addCiudad(nombreCiudad, numHabitantes);
        listaCiudades.add(ciudad);
        return listaCiudades;
    }
*/
    @PostMapping ("/controlador1/addCiudad/{nombreCiudad}/{numHabitantes}")
    public ArrayList<Ciudad> addCiudadAListaCiudades (@RequestParam ("nombreCiudad") String nombreCiudad, @RequestParam ("numHabitantes") int numHabitantes){
        Ciudad ciudad = ciudadService.addCiudad(nombreCiudad, numHabitantes);
        ciudadService.addCiudadALista(ciudad);
        return ciudadService.getListaCiudades();
    }



}


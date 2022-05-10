package com.bosonit.EJERCICIOS.RS1.application;



import com.bosonit.EJERCICIOS.RS1.domain.User;
import com.bosonit.EJERCICIOS.RS1.infrastructure.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ejRS1/user")
public class Controller {

    @Autowired
    UserService userService;

    //EN POSTMAN: GET||  localhost:8080/user
    @PostMapping
    public User postUser(@RequestBody User u){
        userService.postGreeting(u);
        return u;
    }

    @GetMapping("/{id}")
    public String saludoId(@PathVariable String id){
        return "Número de usuario: " + id;
    }

    //EN POSTMAN: PUT||  localhost:8080/user
    @PutMapping
    public User putGreeting(@RequestParam (defaultValue = "0") int id, @RequestParam (defaultValue = "NO NAME") String nombre){
        User user = new User(id, nombre);
        return user;
    }
}

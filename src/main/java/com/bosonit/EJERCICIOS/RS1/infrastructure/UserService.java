package com.bosonit.EJERCICIOS.RS1.infrastructure;



import com.bosonit.EJERCICIOS.RS1.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    User user;

    public User postGreeting(User u){
        user = u;
        return user;
    }

    public User getGreeting(User u){
        return user;
    }
}

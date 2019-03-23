package com.ttn.SpringBootExercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    User user;

    @RequestMapping("/user")
    public User getuser(){

        return user;
    }
}

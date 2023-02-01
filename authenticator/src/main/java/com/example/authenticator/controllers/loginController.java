package com.example.authenticator.controllers;

import com.example.authenticator.data.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class loginController {

    @RequestMapping( method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean validate(@RequestBody User user1){


        return user1.getUsername().equalsIgnoreCase("user1") && user1.getPassword().equals("password1");
    }



}

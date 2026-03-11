package com.proyecto.daw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.daw.model.User;
import com.proyecto.daw.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> showUsers() {
        return userService.findAll();
    }
    
    
}

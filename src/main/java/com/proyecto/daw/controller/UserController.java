package com.proyecto.daw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.daw.model.User;
import com.proyecto.daw.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/users")

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> showUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User showUser(@PathVariable int id){
        return userService.findById(id);
    }
    
    @GetMapping("/count")    
    public Map<String, Object> countUsers() {
        Map<String, Object> obj = new HashMap<>();
        obj.put("users", userService.count());

        return obj;  // Se mapea automáticamente a JSON usando Jackson        
    }

    @GetMapping("/name/contiene/{cadena}")
        public List<User> showUsersNameContiene(@PathVariable("cadena") String name) {
        return userService.findByNameContaining(name);
    }
    
}

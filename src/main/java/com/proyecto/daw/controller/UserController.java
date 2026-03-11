package com.proyecto.daw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.daw.model.User;
import com.proyecto.daw.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    // AÑADIR USUARIO POST

    @PostMapping("")
    public ResponseEntity<Map<String, Object>> createUser(@Valid @RequestBody User user) {
        ResponseEntity<Map<String, Object>> response;
        if (user == null) {
            Map<String, Object> map = new HashMap<>();
            map.put("error", "El cuerpo de la solicitud no puede estar vacío");
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        } else {
            if (user.getNombre() == null || user.getNombre().trim().isEmpty()
                    || user.getCorreo() == null || user.getCorreo().trim().isEmpty()
                    || user.getPassword() == null || user.getPassword().trim().isEmpty()) {
                Map<String, Object> map = new HashMap<>();
                map.put("error", "Los campos 'username', 'email' y 'password' son obligatorios");
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
            } else {
                User usuPost = userService.save(user);
                Map<String, Object> map = new HashMap<>();
                map.put("mensaje", "Usuario creado con éxito");
                map.put("insertUser", usuPost);
                response = ResponseEntity.status(HttpStatus.CREATED).body(map);
            }
        }
        return response;
    }

    
}

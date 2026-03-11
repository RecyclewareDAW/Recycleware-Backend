package com.proyecto.daw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
// @CrossOrigin(origins = "*") // Importante para que React no se queje
@CrossOrigin(origins = "http://localhost:5173")
public class test {

    @GetMapping("/test")
    public String hola() {
        return "¡El Backend de Recycleware está vivo!";
    }
}
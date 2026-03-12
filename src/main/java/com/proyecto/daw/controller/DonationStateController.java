package com.proyecto.daw.controller;

import com.proyecto.daw.exception.ResourceNotFoundException;
import com.proyecto.daw.model.DonationState;
import com.proyecto.daw.repository.DonationStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donation-states")
@CrossOrigin(origins = "http://localhost:3000")
public class DonationStateController {

    @Autowired
    private DonationStateRepository donationStateRepository;

    // 1. Obtener todos los estados (Para el <select> en React)
    // GET http://localhost:8080/api/donation-states
    @GetMapping
    public List<DonationState> getAll() {
        return donationStateRepository.findAll();
    }

    // 2. Obtener un estado por ID
    // GET http://localhost:8080/api/donation-states/1  ---> esto me permite hacer un desplegable para poner el estado en la donación (pendiente, tal)
    @GetMapping("/{id}")
    public DonationState getById(@PathVariable Integer id) {
        return donationStateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estado de donación no encontrado con ID: " + id));
    }
}
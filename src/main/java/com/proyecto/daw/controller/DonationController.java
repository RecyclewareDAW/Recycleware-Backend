package com.proyecto.daw.controller;

import com.proyecto.daw.model.Donation;
import com.proyecto.daw.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/donations")
public class DonationController {
    @Autowired
    private DonationService donationService;

    @GetMapping
    public List<Donation> getAll() {
        return donationService.findAll();
    }

    @GetMapping("/{id}")
    public Donation getById(@PathVariable Integer id) {
        return donationService.findById(id);
    }

    @GetMapping("/usuario/{UsuarioId}")
    public List<Donation> getByUsuarioId(@PathVariable Integer UsuarioId) {
        return donationService.findByUsuarioId(UsuarioId);
    }

    @GetMapping("/ranking")
    public List<Object[]> getRankingEmpresas() {
        return donationService.obtenerRankingEmpresas();
    }

    // Crear nueva donación
    @PostMapping
    public Donation create(@RequestBody Donation donation) {
        return donationService.save(donation);
    }

    // Editar Estado de la donación (Con un desplegable para elegir estado)
    @PutMapping("/{id}/status")
    public Donation updateStatus(@PathVariable Integer id, @RequestBody java.util.Map<String, Integer> body) {
        Integer newStateId = body.get("idEstado");
        return donationService.updateStatus(id, newStateId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        donationService.delete(id);
    }
}
package com.proyecto.daw.controller;

import com.proyecto.daw.model.Donation;
import com.proyecto.daw.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/donations")
@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("/user/{userId}")
    public List<Donation> getByUserId(@PathVariable Integer userId) {
        return donationService.findByUserId(userId);
    }

    @PostMapping
    public Donation create(@RequestBody Donation donation) {
        return donationService.save(donation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        donationService.delete(id);
    }
}
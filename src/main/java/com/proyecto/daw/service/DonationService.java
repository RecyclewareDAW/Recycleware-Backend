package com.proyecto.daw.service;

import com.proyecto.daw.exception.ResourceNotFoundException;
import com.proyecto.daw.model.Donation;
import com.proyecto.daw.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    // Listar todas
    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    // Buscar por ID
    public Donation findById(Integer id) {
        return donationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Donación no encontrada con ID: " + id));
    }

    // Listar por usuario
    public List<Donation> findByUserId(Integer userId) {
        return donationRepository.findByDonanteId(userId);
    }

    // Guardar (Crear o Actualizar)
    @Transactional
    public Donation save(Donation donation) {
        // Aquí podrías añadir lógica: por ejemplo, validar que la descripción no esté vacía
        return donationRepository.save(donation);
    }

    // Borrar
    @Transactional
    public void delete(Integer id) {
        Donation donation = findById(id); // Si no existe, lanza la excepción
        donationRepository.delete(donation);
    }
}
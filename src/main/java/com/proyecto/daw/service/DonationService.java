package com.proyecto.daw.service;

import com.proyecto.daw.exception.ResourceNotFoundException;
import com.proyecto.daw.model.Donation;
import com.proyecto.daw.model.Usuario;
import com.proyecto.daw.model.DonationState;
import com.proyecto.daw.repository.DonationRepository;
import com.proyecto.daw.repository.DonationStateRepository;
import com.proyecto.daw.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;
    @Autowired
    private UsuarioRepository UsuarioRepository;
    @Autowired
    private DonationStateRepository DonationStateRepository;

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
    public List<Donation> findByUsuarioId(Integer UsuarioId) {
        return donationRepository.findByDonanteId(UsuarioId);
    }

    public List<Object[]> obtenerRankingEmpresas() {
        return donationRepository.findRankingEmpresas();
    }

    // Guardar (Crear o Actualizar)
    @Transactional
    public Donation save(Donation donation) {
        // 1. Forzamos que sea una CREACIÓN
        donation.setId(null);

        // 2. Validamos Donante
        if (donation.getDonante() != null && donation.getDonante().getId() != null) {
            Usuario Usuario = UsuarioRepository.findById(donation.getDonante().getId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "El donante con ID " + donation.getDonante().getId() + " no existe."));
            donation.setDonante(Usuario);
        }

        // 3. Validamos Estado
        if (donation.getEstado() != null && donation.getEstado().getId() != null) {
            DonationState state = DonationStateRepository.findById(donation.getEstado().getId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "El estado con ID " + donation.getEstado().getId() + " no existe."));
            donation.setEstado(state);
        }

        // 4. Guardamos
        return donationRepository.save(donation);
    }

    // Actualizar estado de la donación
    @Transactional
    public Donation updateStatus(Integer donationId, Integer newStateId) {
        // Buscamos la donación
        Donation donation = donationRepository.findById(donationId)
                .orElseThrow(() -> new ResourceNotFoundException("Donación no encontrada"));

        // Buscamos el nuevo estado
        DonationState newState = DonationStateRepository.findById(newStateId)
                .orElseThrow(() -> new ResourceNotFoundException("Estado no encontrado"));

        // Cambiamos el estado y guardamos
        donation.setEstado(newState);
        return donationRepository.save(donation);
    }

    // Borrar
    @Transactional
    public void delete(Integer id) {
        Donation donation = findById(id); // Si no existe, lanza la excepción
        donationRepository.delete(donation);
    }

    // Ultima donación
    public java.util.Map<String, Object> obtenerUltimaDonacionFormateada() {
        Donation ultima = donationRepository.findTopByOrderByFechaDonacionDesc();

        if (ultima == null) {
            return null;
        }

        java.util.Map<String, Object> respuesta = new java.util.HashMap<>();

        // Comprobamos si el donante tiene Razón Social (Empresa) o usamos su Nombre (Particular)
        String nombreDonante = ultima.getDonante().getRazonSocial() != null ?
                ultima.getDonante().getRazonSocial() :
                ultima.getDonante().getNombre();

        respuesta.put("donante", nombreDonante);
        respuesta.put("cantidad", ultima.getCantidadProductos());
        respuesta.put("categoria", ultima.getDescripcion());

        return respuesta;
    }
}
package com.proyecto.daw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.daw.model.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
    // Si necesitamos buscar las solicitudes de un usuario concreto, se podría hacer aquí
}
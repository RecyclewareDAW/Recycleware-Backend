package com.proyecto.daw.repository;

import com.proyecto.daw.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {
    // Esto te permitirá en React filtrar las donaciones de un usuario logueado
    // Spring Data JPA genera el SQL automáticamente: 
    // SELECT * FROM donaciones WHERE id_donante = ?
    List<Donation> findByDonanteId(Integer userId);
}
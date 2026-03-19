package com.proyecto.daw.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.daw.model.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
    //Método para buscar las solicitudes por usuario   
    List<Request> findByApplicantId(int applicantId);

    long countByStateId(int stateId);
}
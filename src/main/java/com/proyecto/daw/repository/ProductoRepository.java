package com.proyecto.daw.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.proyecto.daw.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
    // ****************************
    // Métodos HEREDADOS
    // ****************************
    /*
     * findAll()
     * findById(id)
     * 
     * count()
     * delete(User)
     * deleteById(id)
     * deleteAll()
     * 
     * equals(User)
     * exist(User)
     * existById(id)
     */


}

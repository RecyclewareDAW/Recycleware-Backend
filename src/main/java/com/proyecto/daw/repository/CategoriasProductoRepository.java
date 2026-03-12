package com.proyecto.daw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.daw.model.CategoriasProducto;

@Repository
public interface CategoriasProductoRepository extends JpaRepository<CategoriasProducto, Integer> {

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

    @Query(value = "SELECT nombre FROM categorias_producto", nativeQuery = true)
    List<String> findAllNames();
    
    @Query(value = "SELECT * FROM categorias_producto WHERE id = :id ", nativeQuery = true)
    CategoriasProducto findSqlById(@Param("id") int id);

}
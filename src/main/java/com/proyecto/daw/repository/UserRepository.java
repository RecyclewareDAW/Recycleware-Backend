package com.proyecto.daw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.daw.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

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

    @Query(value = "SELECT * FROM usuarios", nativeQuery = true)
    List<User> findSqlAll();

    @Query(value = "SELECT * FROM usuarios WHERE id = :id", nativeQuery = true)
    User findSqlById(@Param("id") int userId);

    @Query(value = "SELECT * FROM usuarios WHERE UPPER(nombre) LIKE UPPER(CONCAT('%', :cadena, '%')) OR UPPER(nombre) LIKE UPPER(CONCAT('%', :cadena, '%'))", nativeQuery = true)
    List<User> findByNameContaining(@Param("cadena") String name);
}

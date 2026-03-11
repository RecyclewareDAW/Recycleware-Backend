package com.proyecto.daw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
}

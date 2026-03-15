package com.proyecto.daw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.daw.model.User;
import com.proyecto.daw.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(int id) {
        return userRepository.findById(id);
    }

    public Long count() {
        return userRepository.count();
    }

    public List<User> findByNameContaining(String name) {
        return userRepository.findByNameContaining(name);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findByCorreo(String correo) {
        return userRepository.findByCorreo(correo);
    }

    public User actualizarUsuario(User usuarioActualizado) {
        // Comprobamos si existe
        if (!userRepository.existsById(usuarioActualizado.getId())) {
            return null;
        }
        return userRepository.save(usuarioActualizado);
    }
}

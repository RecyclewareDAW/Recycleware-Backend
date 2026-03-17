package com.proyecto.daw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.daw.model.Usuario;
import com.proyecto.daw.repository.UsuarioRepository;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository userRepository;

    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

    public Usuario findById(int id) {
        return userRepository.findById(id);
    }

    public Long count() {
        return userRepository.count();
    }

    public List<Usuario> findByNameContaining(String name) {
        return userRepository.findByNameContaining(name);
    }

    public Usuario save(Usuario user) {
        return userRepository.save(user);
    }

    public Usuario findByCorreo(String correo) {
        return userRepository.findByCorreo(correo);
    }

    public Usuario actualizarUsuario(Usuario usuarioActualizado) {
        // Comprobamos si existe
        if (!userRepository.existsById(usuarioActualizado.getId())) {
            return null;
        }
        return userRepository.save(usuarioActualizado);
    }
}

package com.proyecto.daw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.daw.model.Usuario;
import com.proyecto.daw.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository UsuarioRepository;

    public List<Usuario> findAll() {
        return UsuarioRepository.findAll();
    }

    public Usuario findById(int id) {
        return UsuarioRepository.findById(id);
    }

    public Long count() {
        return UsuarioRepository.count();
    }

    public List<Usuario> findByNameContaining(String name) {
        return UsuarioRepository.findByNameContaining(name);
    }

    public Usuario save(Usuario Usuario) {
        return UsuarioRepository.save(Usuario);
    }

    public Usuario findByCorreo(String correo) {
        return UsuarioRepository.findByCorreo(correo);
    }

    public Usuario actualizarUsuario(Usuario usuarioActualizado) {
        // Comprobamos si existe
        if (!UsuarioRepository.existsById(usuarioActualizado.getId())) {
            return null;
        }
        return UsuarioRepository.save(usuarioActualizado);
    }
}

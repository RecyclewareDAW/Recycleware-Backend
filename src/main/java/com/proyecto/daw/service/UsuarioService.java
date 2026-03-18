package com.proyecto.daw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyecto.daw.model.Usuario;
import com.proyecto.daw.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(int id) {
        return usuarioRepository.findById(id);
    }

    public Long count() {
        return usuarioRepository.count();
    }

    public List<Usuario> findByNameContaining(String name) {
        return usuarioRepository.findByNameContaining(name);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario findByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    public Usuario actualizarUsuario(Usuario datosNuevos) {
        // 1. Buscamos el original por el ID que viene de React (el ID 4 en tu caso)
        return usuarioRepository.findById(datosNuevos.getId()).map(usuarioExistente -> {
            if (datosNuevos.getCorreo() != null && !datosNuevos.getCorreo().equals(usuarioExistente.getCorreo())) {
                usuarioExistente.setCorreo(datosNuevos.getCorreo());
            }

            usuarioExistente.setNombre(datosNuevos.getNombre());
            usuarioExistente.setTelefono(datosNuevos.getTelefono());
            usuarioExistente.setDireccion(datosNuevos.getDireccion());
            usuarioExistente.setLocalidad(datosNuevos.getLocalidad());
            usuarioExistente.setCodigoPostal(datosNuevos.getCodigoPostal());

            // IMPORTANTE: No tocamos el correo ni el DNI.
            // Como no cambian, Hibernate sabe que es una ACTUALIZACIÓN y no un INSERT.

            return usuarioRepository.save(usuarioExistente);
        }).orElse(null);
    }
}

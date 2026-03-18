package com.proyecto.daw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.proyecto.daw.model.Usuario;
import com.proyecto.daw.service.UsuarioService;

import jakarta.validation.Valid;

@RequestMapping("/usuario")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("")
    public List<Usuario> showUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario showUsuario(@PathVariable int id) {
        return usuarioService.findById(id);
    }

    @GetMapping("/count")
    public Map<String, Object> countUsuarios() {
        Map<String, Object> obj = new HashMap<>();
        obj.put("Usuarios", usuarioService.count());

        return obj; // Se mapea automáticamente a JSON usando Jackson
    }

    @GetMapping("/name/contiene/{cadena}")
    public List<Usuario> showUsuariosNameContiene(@PathVariable("cadena") String name) {
        return usuarioService.findByNameContaining(name);
    }

    // AÑADIR USUARIO POST

    @PostMapping("")
    public ResponseEntity<Map<String, Object>> createUsuario(@Valid @RequestBody Usuario usuario) {
        Map<String, Object> response = new HashMap<>();

        if (usuario == null) {
            response.put("error", "El cuerpo de la solicitud no puede estar vacío");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        // Validación manual básica (además de @Valid)
        if (usuario.getNombre() == null || usuario.getNombre().trim().isEmpty()
                || usuario.getCorreo() == null || usuario.getCorreo().trim().isEmpty()
                || usuario.getPassword() == null || usuario.getPassword().trim().isEmpty()) {
            response.put("error", "Los campos 'nombre', 'correo' y 'password' son obligatorios");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {
            // 1. IMPORTANTE: Encriptar la contraseña antes de guardar
            String passwordEncriptada = passwordEncoder.encode(usuario.getPassword());
            usuario.setPassword(passwordEncriptada);

            // 2. Guardar usando la instancia inyectada (minúscula)
            Usuario usuPost = usuarioService.save(usuario);

            response.put("mensaje", "Usuario creado con éxito");
            response.put("insertUsuario", usuPost);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            response.put("error", "Error al crear el usuario: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // LOGIN DE USUARIO
    @PostMapping("/login")
    // lo que enviamos desde el login lo guardamos en un map llamado credenciales
    // para utilizarlo
    public ResponseEntity<Map<String, Object>> loginUsuario(@RequestBody Map<String, String> credenciales) {
        String emailFrontend = credenciales.get("email");
        String passwordFrontend = credenciales.get("password");

        // creamos un nuevo mapa para guardar la respuesta
        Map<String, Object> response = new HashMap<>();

        // buscamos al usuario por su correo
        Usuario usuario = usuarioService.findByCorreo(emailFrontend);

        // comprobamos si el usuario y la contraseña son correctos
        if (usuario == null || !passwordEncoder.matches(passwordFrontend, usuario.getPassword())) {
            response.put("error", "Correo o contraseña incorrectos");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        // si esta ok
        response.put("mensaje", "Login exitoso");
        response.put("usuario", usuario);

        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuarioActualizado) {
        // El Service ahora es el que hace el trabajo inteligente
        Usuario usuarioGuardado = usuarioService.actualizarUsuario(usuarioActualizado);

        if (usuarioGuardado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioGuardado);
    }

    @PostMapping("/cambiar-password")
    public ResponseEntity<Map<String, Object>> cambiarPassword(@RequestBody Map<String, String> datos) {
        Map<String, Object> response = new HashMap<>();

        int id = Integer.parseInt(datos.get("id"));
        String actual = datos.get("passwordActual");
        String nueva = datos.get("nuevaPassword");

        Usuario usuario = usuarioService.findById(id);

        // Comparación segura usando el PasswordEncoder de Spring Security
        // passwordEncoder.matches(textoPlano, textoEncriptadoEnBD)
        if (!passwordEncoder.matches(actual, usuario.getPassword())) {
            response.put("error", "La contraseña actual no es correcta.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        // Encriptamos la nueva contraseña antes de guardarla
        usuario.setPassword(passwordEncoder.encode(nueva));
        usuarioService.save(usuario);

        response.put("mensaje", "Contraseña actualizada correctamente");
        return ResponseEntity.ok(response);
    }
}

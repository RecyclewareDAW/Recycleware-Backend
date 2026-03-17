package com.proyecto.daw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.daw.model.Usuario;
import com.proyecto.daw.service.UsuarioService;

import jakarta.validation.Valid;

@RequestMapping("/usuario")
@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioService UsuarioService;

    @GetMapping("")
    public List<Usuario> showUsuarios() {
        return UsuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario showUsuario(@PathVariable int id){
        return UsuarioService.findById(id);
    }
    
    @GetMapping("/count")    
    public Map<String, Object> countUsuarios() {
        Map<String, Object> obj = new HashMap<>();
        obj.put("Usuarios", UsuarioService.count());

        return obj;  // Se mapea automáticamente a JSON usando Jackson        
    }

    @GetMapping("/name/contiene/{cadena}")
        public List<Usuario> showUsuariosNameContiene(@PathVariable("cadena") String name) {
        return UsuarioService.findByNameContaining(name);
    }

    // AÑADIR USUARIO POST

    @PostMapping("")
    public ResponseEntity<Map<String, Object>> createUsuario(@Valid @RequestBody Usuario Usuario) {
        ResponseEntity<Map<String, Object>> response;
        if (Usuario == null) {
            Map<String, Object> map = new HashMap<>();
            map.put("error", "El cuerpo de la solicitud no puede estar vacío");
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        } else {
            if (Usuario.getNombre() == null || Usuario.getNombre().trim().isEmpty()
                    || Usuario.getCorreo() == null || Usuario.getCorreo().trim().isEmpty()
                    || Usuario.getPassword() == null || Usuario.getPassword().trim().isEmpty()) {
                Map<String, Object> map = new HashMap<>();
                map.put("error", "Los campos 'Usuarioname', 'email' y 'password' son obligatorios");
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
            } else {
                Usuario usuPost = UsuarioService.save(Usuario);
                Map<String, Object> map = new HashMap<>();
                map.put("mensaje", "Usuario creado con éxito");
                map.put("insertUsuario", usuPost);
                response = ResponseEntity.status(HttpStatus.CREATED).body(map);
            }
        }
        return response;
    }

    // LOGIN DE USUARIO
    @PostMapping("/login")
    // lo que enviamos desde el login lo guardamos en un map llamado credenciales para utilizarlo
    public ResponseEntity<Map<String, Object>> loginUsuario(@RequestBody Map<String, String> credenciales) {
        String correo = credenciales.get("email");
        String password = credenciales.get("password");

        // creamos un nuevo mapa para guardar la respuesta
        Map<String, Object> response = new HashMap<>();

        // buscamos al usuario por su correo
        Usuario Usuario = UsuarioService.findByCorreo(correo);

        // comprobamos si el usuario y la contraseña son correctos
        if (Usuario == null || !Usuario.getPassword().equals(password)) {
            response.put("error", "Correo o contraseña incorrectos");
            // devolvemos 401 Unauthorized
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        // si esta ok
        response.put("mensaje", "Login exitoso");
        response.put("usuario", Usuario);

        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuarioActualizado) {
        Usuario usuarioGuardado = UsuarioService.actualizarUsuario(usuarioActualizado);
        // Si el Service nos devuelve null, es que no existía (Error 404)
        if (usuarioGuardado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioGuardado);
    }
}

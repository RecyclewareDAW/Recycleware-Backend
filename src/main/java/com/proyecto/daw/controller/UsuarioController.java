package com.proyecto.daw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import com.proyecto.daw.model.Usuario;
import com.proyecto.daw.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RequestMapping("/users")
@RestController
public class UsuarioController {

    @Autowired
    private AuthenticationManager authManager;

    public UsuarioController(AuthenticationManager authManager) {
        this.authManager = authManager;
        // Este método permite conectar este controller con los datos de UserDetails de
        // SecurityConfig
    }

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<Usuario> showUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario showUser(@PathVariable int id) {
        return userService.findById(id);
    }

    @GetMapping("/count")
    public Map<String, Object> countUsers() {
        Map<String, Object> obj = new HashMap<>();
        obj.put("users", userService.count());

        return obj; // Se mapea automáticamente a JSON usando Jackson
    }

    @GetMapping("/name/contiene/{cadena}")
    public List<Usuario> showUsersNameContiene(@PathVariable("cadena") String name) {
        return userService.findByNameContaining(name);
    }

    // AÑADIR USUARIO POST

    @PostMapping("")
    public ResponseEntity<Map<String, Object>> createUser(@Valid @RequestBody Usuario user) {
        ResponseEntity<Map<String, Object>> response;
        if (user == null) {
            Map<String, Object> map = new HashMap<>();
            map.put("error", "El cuerpo de la solicitud no puede estar vacío");
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        } else {
            if (user.getNombre() == null || user.getNombre().trim().isEmpty()
                    || user.getCorreo() == null || user.getCorreo().trim().isEmpty()
                    || user.getPassword() == null || user.getPassword().trim().isEmpty()) {
                Map<String, Object> map = new HashMap<>();
                map.put("error", "Los campos 'username', 'email' y 'password' son obligatorios");
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
            } else {
                Usuario usuPost = userService.save(user);
                Map<String, Object> map = new HashMap<>();
                map.put("mensaje", "Usuario creado con éxito");
                map.put("insertUser", usuPost);
                response = ResponseEntity.status(HttpStatus.CREATED).body(map);
            }
        }
        return response;
    }

    // LOGIN DE USUARIO
    @PostMapping("/login")
    // lo que enviamos desde el login lo guardamos en un map llamado credenciales
    // para utilizarlo
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody Map<String, String> credenciales,
            HttpServletRequest request) {
        String correo = credenciales.get("email");
        String password = credenciales.get("password");

        // creamos un nuevo mapa para guardar la respuesta
        Map<String, Object> response = new HashMap<>();

        // buscamos al usuario por su correo
        Usuario user = userService.findByCorreo(correo);

        // comprobamos si el usuario y la contraseña son correctos
        if (user == null || !user.getPassword().equals(password)) {
            response.put("error", "Correo o contraseña incorrectos");
            // devolvemos 401 Unauthorized
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        // INSERTAR AUTHENTICATIN Y CONTEXT AQUI -> enpointlogin.png

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(correo, password));

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);

        // Muy importante: guardar en la sesión
        request.getSession(true).setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                context);

        // FIN AUTH

        // si esta ok
        response.put("mensaje", "Login exitoso");
        response.put("usuario", user);

        return ResponseEntity.ok(response);
    }

    // INSERTAR LOGOUT PARA EL SPRING SECURITY

    @PutMapping
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuarioActualizado) {
        Usuario usuarioGuardado = userService.actualizarUsuario(usuarioActualizado);
        // Si el Service nos devuelve null, es que no existía (Error 404)
        if (usuarioGuardado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioGuardado);
    }
}

package com.proyecto.daw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.daw.model.Request;
import com.proyecto.daw.service.RequestService;

@RestController
@RequestMapping("/solicitudes")
public class RequestController {

    @Autowired
    private RequestService requestService;

    // 1. ENDPOINT PARA EL ADMIN: Ver todas las solicitudes pendientes o totales
    @GetMapping("/todas")
    public ResponseEntity<List<Request>> getAllRequests() {
        List<Request> requests = requestService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(requests);
    }

    // 2. ENDPOINT PARA EL USUARIO: Crear una nueva solicitud
    @PostMapping("")
    public ResponseEntity<Map<String, Object>> createRequest(@RequestBody Map<String, Object> payload) {
        Map<String, Object> response = new HashMap<>();

        try {
            // Extraemos los datos del JSON plano que nos manda React
            // Usamos toString() y luego parseamos para evitar problemas de tipos
            int idSolicitante = Integer.parseInt(payload.get("idSolicitante").toString());
            int idProducto = Integer.parseInt(payload.get("idProducto").toString());
            String motivo = payload.get("motivo").toString();

            // Validación extra
            if (motivo == null || motivo.trim().isEmpty()) {
                response.put("error", "El motivo de la solicitud es obligatorio.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }

            // Llamamos a nuestro servicio para que haga la unión
            Request nuevaSolicitud = requestService.crearSolicitud(idSolicitante, idProducto, motivo);

            response.put("mensaje", "Solicitud creada con éxito. ¡Mucha suerte!");
            response.put("solicitud", nuevaSolicitud);
            
            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (IllegalArgumentException e) {
            // Este catch atrapa el error si el usuario o el producto no existen en H2
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            
        } catch (Exception e) {
            // Por si nos mandan un JSON mal formado o faltan campos
            response.put("error", "Error al procesar los datos de la solicitud. Revisa el formato.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
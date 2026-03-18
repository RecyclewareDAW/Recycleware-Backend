package com.proyecto.daw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.daw.model.Producto;
import com.proyecto.daw.model.Request;
import com.proyecto.daw.model.RequestState;
import com.proyecto.daw.model.Usuario;
import com.proyecto.daw.repository.RequestRepository;
import com.proyecto.daw.repository.RequestStateRepository;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private RequestStateRepository requestStateRepository;

    @Autowired
    private UsuarioService UsuarioService;

    @Autowired
    private ProductoService productoService;

    // 1. Método para el ADMIN: Ver todas las solicitudes
    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    // 2. Método para el USUARIO: Crear una nueva solicitud
    public Request crearSolicitud(int idSolicitante, int idProducto, String motivo) {
        
        // Buscamos los objetos completos usando los IDs que nos manda React
        Usuario solicitante = UsuarioService.findById(idSolicitante);
        Producto producto = productoService.findById(idProducto);

        // Buscamos el estado inicial "Pendiente" 
        RequestState estadoPendiente = requestStateRepository.findById(1).orElse(null);

        // Validación de seguridad
        if (solicitante == null || producto == null || estadoPendiente == null) {
            throw new IllegalArgumentException("Error: No se ha encontrado el usuario, el producto o el estado.");
        }

        // Ensamblamos la nueva solicitud 
        Request nuevaSolicitud = new Request();
        nuevaSolicitud.setApplicant(solicitante);
        nuevaSolicitud.setProduct(producto);
        nuevaSolicitud.setReason(motivo);
        nuevaSolicitud.setState(estadoPendiente);

        // La guardamos en H2 y devolvemos el resultado
        return requestRepository.save(nuevaSolicitud);
    }

    // 3. Método para el USUARIO: Ver solo sus solicitudes
    public List<Request> obtenerSolicitudesPorUsuario(int idSolicitante) {
        return requestRepository.findByApplicantId(idSolicitante);
    }

    // 4. Método para el ADMIN: Actualizar el estado de una solicitud
    public Request updateStatus(int idSolicitud, int idNuevoEstado) {
        
        // 1. Buscamos la solicitud en la base de datos
        Request solicitud = requestRepository.findById(idSolicitud).orElse(null);
        if (solicitud == null) {
            throw new IllegalArgumentException("Error: No se ha encontrado la solicitud con ID " + idSolicitud);
        }

        // 2. Buscamos el nuevo estado que nos han pedido
        RequestState nuevoEstado = requestStateRepository.findById(idNuevoEstado).orElse(null);
        if (nuevoEstado == null) {
            throw new IllegalArgumentException("Error: No se ha encontrado el estado con ID " + idNuevoEstado);
        }

        // Marcamos el producto de la solicitud como no disponible si se aprueba la solicitud
        if (nuevoEstado.getName().equals("Aprobada") || nuevoEstado.getName().equals("Entregada")) {
            productoService.marcarProductoNoDisponibleById(solicitud.getProduct().getId());
        }

        // 3. Actualizamos y guardamos
        solicitud.setState(nuevoEstado);



        return requestRepository.save(solicitud);
    }
}
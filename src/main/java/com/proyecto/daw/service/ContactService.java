package com.proyecto.daw.service;

import com.proyecto.daw.model.Contact;
import com.proyecto.daw.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    // Guardo el mensaje en la BDD
    public Contact guardarMensaje(Contact contacto) {
        return contactRepository.save(contacto);
    }

    // Accedo a BDD y saco una lista de todos los mensajes
    public List<Contact> obtenerTodos() {
        return contactRepository.findAll();
    }


}
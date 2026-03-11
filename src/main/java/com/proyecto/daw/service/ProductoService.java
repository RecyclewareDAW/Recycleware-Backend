package com.proyecto.daw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.daw.model.Producto;
import com.proyecto.daw.model.User;
import com.proyecto.daw.repository.ProductosRepository;

public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findSqlAll();
    }

    public Producto findById(int id) {
        return productoRepository.findById(id);
    }

    public Long count() {
        return productoRepository.count();
    }
}

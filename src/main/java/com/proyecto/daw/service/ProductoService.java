package com.proyecto.daw.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.daw.model.Producto;
import com.proyecto.daw.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findSqlAll();
    }

    public Producto findById(int id) {
        return productoRepository.findSqlById(id);
    }

    public List<Producto> findByCategoriaString(String categoria) {
        List<Producto> lista = new ArrayList<Producto>();
        for (Producto producto : productoRepository.findAll()) {
            if (producto.getCategoria().getNombre().equals(categoria)) {
                lista.add(producto);
            }
        }
        return lista;
    }

    public List<Producto> findByEstadpString(String estado) {
        List<Producto> lista = new ArrayList<Producto>();
        for (Producto producto : productoRepository.findAll()) {
            if (producto.getEstado().getNombre().equals(estado)) {
                lista.add(producto);
            }
        }
        return lista;
    }

    public Long count() {
        return productoRepository.count();
    }
}

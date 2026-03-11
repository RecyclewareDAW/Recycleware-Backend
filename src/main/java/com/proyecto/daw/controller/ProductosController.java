package com.proyecto.daw.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.daw.model.Producto;
import com.proyecto.daw.service.ProductoService;


@RequestMapping("/productos")

@RestController
public class ProductosController {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public List<Producto> showProductos() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public Producto showProductoById(@PathVariable int id){
        return productoService.findById(id);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Producto> showProductoByCategoriaString(@PathVariable String categoria){
        return productoService.findByCategoriaString(categoria);
    }

    @GetMapping("/estado/{estado}")
    public List<Producto> showProductoByEstadoString(@PathVariable String estado){
        return productoService.findByCategoriaString(estado);
    }
    
}

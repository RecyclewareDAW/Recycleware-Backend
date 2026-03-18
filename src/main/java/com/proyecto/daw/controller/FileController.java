package com.proyecto.daw.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@RequestMapping("/images")
@Controller
public class FileController {

    // Endpoint to serve image file
    @GetMapping("/{id}")
    public ResponseEntity<Resource> getImage(@PathVariable int id) throws Exception {
        // Path to the image file
        ArrayList<Path> listaImagenes = new ArrayList<Path>();
        listaImagenes.add(Paths.get("Recycleware-Backend/src/main/resources/static/images/resized_artecPc.jpg"));
        listaImagenes.add(Paths.get("Recycleware-Backend/src/main/resources/static/images/resized_Dell_Computer_Monitor.png"));
        listaImagenes.add(Paths.get("Recycleware-Backend/src/main/resources/static/images/resized_DellP2212Hb.jpg"));
        listaImagenes.add(Paths.get("Recycleware-Backend/src/main/resources/static/images/resized_LaptopBrokenScreen.jpg"));
        listaImagenes.add(Paths.get("Recycleware-Backend/src/main/resources/static/images/resized_LenovoG500.jpg"));
        listaImagenes.add(Paths.get("Recycleware-Backend/src/main/resources/static/images/resized_LogitechMouse.jpg"));
        listaImagenes.add(Paths.get("Recycleware-Backend/src/main/resources/static/images/resized_Old_Computer_Mouse.jpg"));
        listaImagenes.add(Paths.get("Recycleware-Backend/src/main/resources/static/images/resized_SapphireRadeonHD5570.jpg"));
        listaImagenes.add(Paths.get("Recycleware-Backend/src/main/resources/static/images/resizedIntelCorei7.jpg"));
        // Path path =
        // Paths.get("Recycleware-Backend/src/main/resources/static/images/resized_artecPc.jpg");
        // Load the resource
        Resource resource = new UrlResource(listaImagenes.get(id).toUri());
        if (resource != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(resource);
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(null);
        // Return ResponseEntity with image content type

    }
}
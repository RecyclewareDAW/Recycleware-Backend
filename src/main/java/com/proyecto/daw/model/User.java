package com.proyecto.daw.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios") // Nombre exacto de la tabla
@Data 
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 9, unique = true)
    private String dni;

    @Column(nullable = false, length = 15)
    private String telefono;

    @Column(nullable = false, length = 100, unique = true)
    private String correo;

    @Column(name = "contraseña", nullable = false, length = 255)
    private String password;

    @Column(nullable = false, length = 200)
    private String direccion;

    @Column(nullable = false, length = 100)
    private String provincia;

    @Column(name = "codigo_postal", nullable = false, length = 10)
    private String codigoPostal;

    @Column(name = "razon_social", length = 100)
    private String razonSocial;

    @Column(name = "nombre_contacto", length = 100)
    private String nombreContacto;
}
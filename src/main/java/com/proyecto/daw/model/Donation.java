package com.proyecto.daw.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "donaciones")
@Data
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relación con modelo User
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_donante") 
    private User donante;

    // Relación con el estado de la donación
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_estado", nullable = false)
    private DonationState estado;

    @Column(name = "fecha_donacion", insertable = false, updatable = false)
    private LocalDateTime fechaDonacion;

    @Column(name = "cantidad_productos")
    private Integer cantidadProductos;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    private Float peso;
}
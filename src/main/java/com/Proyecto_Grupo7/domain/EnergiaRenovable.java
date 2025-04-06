package com.Proyecto_Grupo7.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;



@Data
@Entity
@Table(name = "energias_renovables")
public class EnergiaRenovable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_energias_renovables;

    private String titulo;
    private String descripcion;

    @Column(name = "imagen_url")
    private String imagenUrl;

    public EnergiaRenovable(String descripcion, Long id_energias_renovables, String imagenUrl, String titulo) {
        this.descripcion = descripcion;
        this.id_energias_renovables = id_energias_renovables;
        this.imagenUrl = imagenUrl;
        this.titulo = titulo;
    }

    public EnergiaRenovable() {
    }


    



}

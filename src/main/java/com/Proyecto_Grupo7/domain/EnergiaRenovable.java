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

    public Long getId_energias_renovables() {
        return id_energias_renovables;
    }

    public void setId_energias_renovables(Long id_energias_renovables) {
        this.id_energias_renovables = id_energias_renovables;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }


    



}

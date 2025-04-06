/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Grupo7.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "detalle_cabina")
public class DetalleCabina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_cabina")
    private long idDetalleCabina;

    private String nombre;
    private String descripcion;
    private double precio;

    @Column(name = "ruta_imagen")
    private String rutaImagen;

    @Column(name = "galeria_imagenes")
    private String galeriaImagenes;

    private boolean activo;

    public DetalleCabina() {
    }

    public DetalleCabina(String nombre, String descripcion, Double precio, boolean activo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.activo = activo;
    }
}

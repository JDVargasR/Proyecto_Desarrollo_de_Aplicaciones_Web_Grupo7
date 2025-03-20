/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Grupo7.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "habitacion")
public class Habitaciones implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private long idHabitacion;

    private String descripcion;

    @Column(name = "ruta_imagen")
    private String rutaImagen;

    private boolean activo;

    public Habitaciones() {
    }

    public Habitaciones(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
}

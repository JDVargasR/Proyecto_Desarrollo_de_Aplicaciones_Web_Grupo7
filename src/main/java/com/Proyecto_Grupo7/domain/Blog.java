/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Grupo7.domain;

/**
 *
 * @author gmora
 */

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "Blog")
public class Blog implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_blog")
    private long idBlog;

    private String descripcion;

    

    private boolean activo;
    private String titulo;
    private String contenido;

    public Blog() {
    }

    public Blog(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
}

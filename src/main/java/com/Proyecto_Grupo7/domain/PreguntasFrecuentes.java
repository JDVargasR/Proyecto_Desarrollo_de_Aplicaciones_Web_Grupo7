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
@Table(name = "preguntas_frecuentes")
public class PreguntasFrecuentes implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pregunta")
    private long idPregunta;

    private String pregunta;

    @Column(name = "respuesta")
    private String respuesta;

    private boolean activo;

    public PreguntasFrecuentes() {
    }

    public PreguntasFrecuentes(String pregunta, boolean activo) {
        this.pregunta = pregunta;
        this.activo = activo;
    }
}

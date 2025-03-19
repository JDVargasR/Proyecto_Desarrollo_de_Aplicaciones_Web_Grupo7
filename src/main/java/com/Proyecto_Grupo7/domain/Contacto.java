/*
 * esta en la pagina de contacto hecha por Josue 
 */
package com.Proyecto_Grupo7.domain;


import java.io.Serializable;

import com.google.cloud.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "contacto")
public class Contacto implements Serializable{
     /*al hacer implements Serializable lleva : */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contacto")  // <-- Esto le indica a JPA que el campo en la BD es 'id_contacto'
    private Long idContacto;

    private String nombre;
    private String correo;
    private String telefono;
    private String mensaje;

    private boolean activo;

    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp fecha_envio;

    public Contacto() {
    }

    public Contacto(Long idContacto, String nombre, String correo, String telefono, String mensaje, boolean activo,
            Timestamp fecha_envio) {
        this.idContacto = idContacto;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.mensaje = mensaje;
        this.activo = activo;
        this.fecha_envio = fecha_envio;
    }













    
}

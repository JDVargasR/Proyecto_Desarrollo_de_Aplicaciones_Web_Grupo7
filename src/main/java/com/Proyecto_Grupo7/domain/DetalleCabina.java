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

    public long getIdDetalleCabina() {
        return idDetalleCabina;
    }

    public void setIdDetalleCabina(long idDetalleCabina) {
        this.idDetalleCabina = idDetalleCabina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getGaleriaImagenes() {
        return galeriaImagenes;
    }

    public void setGaleriaImagenes(String galeriaImagenes) {
        this.galeriaImagenes = galeriaImagenes;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}

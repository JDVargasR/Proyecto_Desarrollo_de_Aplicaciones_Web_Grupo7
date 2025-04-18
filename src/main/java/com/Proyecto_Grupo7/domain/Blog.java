
package com.Proyecto_Grupo7.domain;



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

    private String imagenUrl;

    public Blog() {
    }

    public Blog(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Blog(boolean activo, String contenido, String descripcion, long idBlog, String imagenUrl, String titulo) {
        this.activo = activo;
        this.contenido = contenido;
        this.descripcion = descripcion;
        this.idBlog = idBlog;
        this.imagenUrl = imagenUrl;
        this.titulo = titulo;
    }


    

    public long getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(long idBlog) {
        this.idBlog = idBlog;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }


}

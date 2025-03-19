/*
 * servicio contacto
 */
package com.Proyecto_Grupo7.service;

import java.util.List;

import com.Proyecto_Grupo7.domain.Contacto;


public interface ContactoService {


    public List<Contacto> obtenerContactos(boolean activos);
    
    public Contacto obtenerContactos(Contacto Contacto);

    public List<Contacto> obtenerContactos();

    public Contacto guardarContacto(Contacto contacto);

    public void eliminarContacto(long  id);
}

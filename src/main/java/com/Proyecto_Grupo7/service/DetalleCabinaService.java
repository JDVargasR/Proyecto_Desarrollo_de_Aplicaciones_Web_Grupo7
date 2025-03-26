/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto_Grupo7.service;

import java.util.List;

import com.Proyecto_Grupo7.domain.DetalleCabina;

/**
 *
 * @author josed
 */
public interface DetalleCabinaService {
    // Se obtiene un listado de categorias en un List
    public List<DetalleCabina> getDetalleCabina(boolean activos);
    
   // Se obtiene un Categoria, a partir del id de un categoria
    public DetalleCabina getImagen(DetalleCabina detallecabina);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(DetalleCabina detallecabina);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(DetalleCabina detallecabina);
    
    DetalleCabina getDetalleCabinaById(Long id);
}


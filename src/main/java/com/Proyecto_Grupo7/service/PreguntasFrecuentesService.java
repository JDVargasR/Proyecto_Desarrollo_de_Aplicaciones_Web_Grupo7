/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto_Grupo7.service;

import com.Proyecto_Grupo7.domain.PreguntasFrecuentes;
import java.util.List;

/**
 *
 * @author josed
 */
public interface PreguntasFrecuentesService {
    // Se obtiene un listado de categorias en un List
    public List<PreguntasFrecuentes> getPreguntasFrecuentes(boolean activos);
    
   // Se obtiene un Categoria, a partir del id de un categoria
    public PreguntasFrecuentes getImagen(PreguntasFrecuentes preguntasfrecuentes);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(PreguntasFrecuentes preguntasfrecuentes);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(PreguntasFrecuentes preguntasfrecuentes);
}

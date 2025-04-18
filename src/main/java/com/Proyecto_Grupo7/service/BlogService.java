/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto_Grupo7.service;

import com.Proyecto_Grupo7.domain.Blog;
import java.util.List;

public interface BlogService {
    
    // Se obtiene un listado de categorias en un List
    public List<Blog> getBlog(boolean activos);
    
   // Se obtiene un Categoria, a partir del id de un categoria
    public Blog getBlog(Blog blog);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Blog blog);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Blog blog);
    
}

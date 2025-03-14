/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto_Grupo7.dao;

import com.Proyecto_Grupo7.domain.Imagenes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author josed
 */

public interface ImagenesDao extends JpaRepository <Imagenes,Long>{
    
}

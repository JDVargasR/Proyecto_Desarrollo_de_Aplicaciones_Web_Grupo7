/*
 * comunicacion con la base datos contacto por josue
 */
package com.Proyecto_Grupo7.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto_Grupo7.domain.Contacto;

public interface ContactoDao extends JpaRepository <Contacto,Long>{

    Object getById(long id_contacto);
    
}

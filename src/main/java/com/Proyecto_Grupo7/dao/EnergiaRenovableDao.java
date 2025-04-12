package com.Proyecto_Grupo7.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto_Grupo7.domain.EnergiaRenovable;

/**
 *
 * @author gmora
 */

public interface  EnergiaRenovableDao extends JpaRepository<EnergiaRenovable, Long> {
    
}

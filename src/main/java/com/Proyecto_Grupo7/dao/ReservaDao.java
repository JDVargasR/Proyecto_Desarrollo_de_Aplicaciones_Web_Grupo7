package com.Proyecto_Grupo7.dao;

import com.Proyecto_Grupo7.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaDao extends JpaRepository<Reserva, Long> {
}

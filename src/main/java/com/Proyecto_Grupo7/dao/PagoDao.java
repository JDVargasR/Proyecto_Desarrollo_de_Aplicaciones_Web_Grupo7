package com.Proyecto_Grupo7.dao;

import com.Proyecto_Grupo7.domain.Pago;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PagoDao extends JpaRepository <Pago, Long> {
}

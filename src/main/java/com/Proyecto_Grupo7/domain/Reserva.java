package com.Proyecto_Grupo7.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;

    @Column(name = "fecha_entrada")
    private String fechaEntrada;

    @Column(name = "fecha_salida")
    private String fechaSalida;

    private int personas;

    @ManyToOne
    @JoinColumn(name = "id_detalle_cabina")
    private DetalleCabina cabina;

}
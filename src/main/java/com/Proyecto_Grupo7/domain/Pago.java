package com.Proyecto_Grupo7.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "pago")
public class Pago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    private String nombreTarjeta;
    private String numeroTarjeta;
    private String codigoSeguridad;
    private String mes;
    private String anio;

    @OneToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;
}
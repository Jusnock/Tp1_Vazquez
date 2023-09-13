package com.utn.Py.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Factura implements Serializable {
    @Id
    @GeneratedValue()
    private Long Id;
    private int numero;
    private LocalDate fecha;
    private double descuento;
    private int total;
}

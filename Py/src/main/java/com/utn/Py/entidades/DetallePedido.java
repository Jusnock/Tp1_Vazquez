package com.utn.Py.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DetallePedido implements Serializable {
    @Id
    @GeneratedValue()
    private Long Id;
    private int cantidad;
    private double subtotal;

    @ManyToOne
    @JoinColumn(name = "Producto_id")
    Producto producto;


}



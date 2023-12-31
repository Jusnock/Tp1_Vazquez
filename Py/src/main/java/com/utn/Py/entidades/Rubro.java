package com.utn.Py.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Rubro implements Serializable {
    @Id
    @GeneratedValue()
    private Long Id;
    private String denominacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "Rubro_id")
    @Builder.Default
    private List<Producto> productos=new ArrayList<>();
    public void agregarProductos(Producto producto){
        productos.add(producto);
    }

}

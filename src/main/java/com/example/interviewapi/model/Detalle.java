package com.example.interviewapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Detalles")
public class Detalle {

    @EmbeddedId
    private DetalleId id;

    @ManyToOne
    @MapsId("id_producto")
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Producto producto;

    private Long cantidad;

    private Double precio;

}

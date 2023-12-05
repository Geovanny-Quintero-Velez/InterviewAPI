package com.example.interviewapi.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class DetalleId implements Serializable{

    @Column(name = "num_detalle")
    private Long num_detalle;

    @Column(name = "id_factura")
    private Long id_factura;
}

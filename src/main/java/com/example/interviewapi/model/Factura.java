package com.example.interviewapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Facturas")
public class Factura {
    @Id
    private Long num_factura;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cliente cliente;

    private Date fecha;

    @Override
    public String toString(){
        return "cliente: " + cliente.toString() + "\n " + "fecha-orden: " + fecha + "\n " ;
    }
}

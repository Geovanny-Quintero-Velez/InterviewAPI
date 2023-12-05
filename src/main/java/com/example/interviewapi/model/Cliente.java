package com.example.interviewapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Clientes")
public class Cliente {
    @Id
    private Long id_cliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private Date fecha_nacimiento;
    private String correo;
    private String telefono;
    private String categoria;

    public String toString(){
        return "name: " + nombre + "\n apellido: " + apellido;
    }
}

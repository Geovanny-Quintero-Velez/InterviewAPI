package com.example.interviewapi.service;

import com.example.interviewapi.model.Cliente;
import com.example.interviewapi.model.Detalle;
import com.example.interviewapi.model.DetalleId;

import java.util.List;
import java.util.Optional;

public interface DetalleService {

    public Detalle crearDetalle(Detalle detalle);

    public List<Detalle> obtenerTodosLosDetalles();

    public Optional<Detalle> obtenerDetallePorId(DetalleId id);

    public List<Detalle> obtenerDetallesPorFactura(Long num_factura);

    public Detalle actualizarDetalle(DetalleId id, Detalle nuevoDetalle);

    public void eliminarDetalle(DetalleId id);
}

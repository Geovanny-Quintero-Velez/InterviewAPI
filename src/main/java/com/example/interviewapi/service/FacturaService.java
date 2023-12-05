package com.example.interviewapi.service;

import com.example.interviewapi.model.Cliente;
import com.example.interviewapi.model.Detalle;
import com.example.interviewapi.model.Factura;

import java.util.List;
import java.util.Optional;

public interface FacturaService {

    public Factura crearFactura(Factura factura);

    public List<Factura> obtenerTodasLasFacturas();

    public Optional<Factura> obtenerFacturaPorId(Long id);

    public Factura actualizarFactura(Long id, Factura nuevaFactura);

    public void eliminarFactura(Long id);

    public boolean haveDiscount(List<Detalle> detalles);

    public void applyDiscount(Long id);
}

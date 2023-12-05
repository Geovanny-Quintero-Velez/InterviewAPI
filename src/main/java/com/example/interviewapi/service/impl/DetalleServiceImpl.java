package com.example.interviewapi.service.impl;

import com.example.interviewapi.model.Detalle;
import com.example.interviewapi.model.DetalleId;
import com.example.interviewapi.repository.DetalleRepository;
import com.example.interviewapi.repository.FacturaRepository;
import com.example.interviewapi.service.DetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleServiceImpl implements DetalleService {

    @Autowired
    private DetalleRepository detalleRepository;

    @Override
    public Detalle crearDetalle(Detalle detalle) {
        return detalleRepository.save(detalle);
    }

    @Override
    public List<Detalle> obtenerTodosLosDetalles() {
        return detalleRepository.findAll();
    }

    @Override
    public Optional<Detalle> obtenerDetallePorId(DetalleId id) {
        return detalleRepository.findById(id);
    }

    @Override
    public List<Detalle> obtenerDetallesPorFactura(Long num_factura) {
        return detalleRepository.finByFactura(num_factura);
    }

    @Override
    public Detalle actualizarDetalle(DetalleId id, Detalle nuevoDetalle) {
        return detalleRepository.findById(id).map(detalle -> detalleRepository.save(nuevoDetalle)).orElse(null);
    }

    @Override
    public void eliminarDetalle(DetalleId id) {
        detalleRepository.deleteById(id);
    }
}

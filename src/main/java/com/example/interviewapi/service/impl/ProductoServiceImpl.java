package com.example.interviewapi.service.impl;

import com.example.interviewapi.model.Producto;
import com.example.interviewapi.repository.DetalleRepository;
import com.example.interviewapi.repository.ProductoRepository;
import com.example.interviewapi.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto actualizarProducto(Long id, Producto nuevoProducto) {
        return productoRepository.findById(id).map(producto -> productoRepository.save(nuevoProducto)).orElse(null);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}

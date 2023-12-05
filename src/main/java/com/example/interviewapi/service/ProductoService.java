package com.example.interviewapi.service;

import com.example.interviewapi.model.Cliente;
import com.example.interviewapi.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    public Producto crearProducto(Producto producto);

    public List<Producto> obtenerTodosLosProductos();

    public Optional<Producto> obtenerProductoPorId(Long id);

    public Producto actualizarProducto(Long id, Producto nuevoProducto);

    public void eliminarProducto(Long id);
}

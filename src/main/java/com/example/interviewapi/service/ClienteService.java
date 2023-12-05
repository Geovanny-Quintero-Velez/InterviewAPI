package com.example.interviewapi.service;

import com.example.interviewapi.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    public Cliente crearCliente(Cliente cliente);

    public List<Cliente> obtenerTodosLosClientes();

    public Optional<Cliente> obtenerClientePorId(Long id);

    public Cliente actualizarCliente(Long id, Cliente nuevoCliente);

    public void eliminarCliente(Long id);
}

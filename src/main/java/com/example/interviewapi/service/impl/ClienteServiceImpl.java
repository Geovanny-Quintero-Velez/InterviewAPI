package com.example.interviewapi.service.impl;

import com.example.interviewapi.model.Cliente;
import com.example.interviewapi.repository.ClienteRepository;
import com.example.interviewapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente actualizarCliente(Long id, Cliente nuevoCliente) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNombre(nuevoCliente.getNombre());
            cliente.setApellido(nuevoCliente.getApellido());
            cliente.setDireccion(nuevoCliente.getDireccion());
            cliente.setFecha_nacimiento(nuevoCliente.getFecha_nacimiento());
            cliente.setCorreo(nuevoCliente.getCorreo());
            cliente.setTelefono(nuevoCliente.getTelefono());
            cliente.setCategoria(nuevoCliente.getCategoria());
            return clienteRepository.save(cliente);
        }).orElse(null);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}

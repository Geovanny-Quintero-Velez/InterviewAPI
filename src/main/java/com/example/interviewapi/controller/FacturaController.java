package com.example.interviewapi.controller;

import com.example.interviewapi.model.Factura;
import com.example.interviewapi.service.impl.FacturaServiceImpl;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/facturas/")
public class FacturaController {

    @Autowired
    private FacturaServiceImpl facturaService;

    @PostMapping("facturas")
    public ResponseEntity<Factura> crearFactura(@RequestBody Factura factura) {
        Factura nuevaFactura = facturaService.crearFactura(factura);
        return new ResponseEntity<>(nuevaFactura, HttpStatus.CREATED);
    }

    @GetMapping("facturas")
    public ResponseEntity<List<Factura>> obtenerTodasLasFacturas() {
        List<Factura> facturas = facturaService.obtenerTodasLasFacturas();
        return new ResponseEntity<>(facturas, HttpStatus.OK);
    }

    @GetMapping("facturas/{id}")
    public ResponseEntity<Factura> obtenerFacturaPorId(@PathVariable Long id) {
        Optional<Factura> factura = facturaService.obtenerFacturaPorId(id);
        return factura.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("facturas/{id}")
    public ResponseEntity<Factura> actualizarFactura(@PathVariable Long id, @RequestBody Factura nuevaFactura) {
        Factura facturaActualizada = facturaService.actualizarFactura(id, nuevaFactura);
        return facturaActualizada != null
                ? new ResponseEntity<>(facturaActualizada, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("facturas/{id}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable Long id) {
        facturaService.eliminarFactura(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

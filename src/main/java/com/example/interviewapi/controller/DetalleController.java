package com.example.interviewapi.controller;

import com.example.interviewapi.model.Cliente;
import com.example.interviewapi.model.Detalle;
import com.example.interviewapi.model.DetalleId;
import com.example.interviewapi.service.impl.ClienteServiceImpl;
import com.example.interviewapi.service.impl.DetalleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalles/")
public class DetalleController {

    @Autowired
    private DetalleServiceImpl detalleService;

    @PostMapping("detalles")
    public ResponseEntity<Detalle> crearDetalle(@RequestBody Detalle detalle) {
        Detalle nuevoDetalle = detalleService.crearDetalle(detalle);
        return new ResponseEntity<>(nuevoDetalle, HttpStatus.CREATED);
    }

    @GetMapping("detalles")
    public ResponseEntity<List<Detalle>> obtenerTodosLosDetalles() {
        List<Detalle> detalles = detalleService.obtenerTodosLosDetalles();
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    @GetMapping("detalles/{idDetalle}/{idFactura}")
    public ResponseEntity<Detalle> obtenerDetallePorId(@PathVariable Long idDetalle, @PathVariable Long idFactura) {
        DetalleId id = new DetalleId(idDetalle, idFactura);
        Optional<Detalle> detalle = detalleService.obtenerDetallePorId(id);
        return detalle.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("detalles/{idDetalle}/{idFactura}")
    public ResponseEntity<Detalle> actualizarDetalle(@PathVariable Long idDetalle, @PathVariable Long idFactura, @RequestBody Detalle nuevoDetalle) {
        DetalleId id = new DetalleId(idDetalle, idFactura);
        Detalle detalleActualizado = detalleService.actualizarDetalle(id, nuevoDetalle);
        return detalleActualizado != null
                ? new ResponseEntity<>(detalleActualizado, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("detalles/{idDetalle}/{idFactura}")
    public ResponseEntity<Void> eliminarDetalle(@PathVariable Long idDetalle, @PathVariable Long idFactura) {
        DetalleId id = new DetalleId(idDetalle, idFactura);
        detalleService.eliminarDetalle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

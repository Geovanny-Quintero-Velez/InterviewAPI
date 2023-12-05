package com.example.interviewapi.service.impl;

import com.example.interviewapi.model.Detalle;
import com.example.interviewapi.model.Factura;
import com.example.interviewapi.repository.ClienteRepository;
import com.example.interviewapi.repository.FacturaRepository;
import com.example.interviewapi.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private DetalleServiceImpl detalleService;

    @Override
    public Factura crearFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public List<Factura> obtenerTodasLasFacturas() {
        return facturaRepository.findAll();
    }

    @Override
    public Optional<Factura> obtenerFacturaPorId(Long id) {
        return facturaRepository.findById(id);
    }

    @Override
    public Factura actualizarFactura(Long id, Factura nuevaFactura) {
        return facturaRepository.findById(id).map(factura -> facturaRepository.save(nuevaFactura)).orElse(null);
    }

    @Override
    public void eliminarFactura(Long id) {
        facturaRepository.deleteById(id);
    }

    @Override
    public boolean haveDiscount(List<Detalle> detalles) {
        int cantidadParaDescuento = 5;
        double cobroAcumuladoParaDescuento = 1000000.0;
        Double precio = 0.0;

        for (Detalle detalle : detalles){
            precio += detalle.getPrecio();
            if(precio > cobroAcumuladoParaDescuento)
                break;
        }
        boolean applyDiscount = ((detalles.size() == cantidadParaDescuento) && precio>cobroAcumuladoParaDescuento);
        return applyDiscount;
    }

    @Override
    public void applyDiscount(Long id) {
        Double descuento = 0.1;
        List<Detalle> detalles = detalleService.obtenerDetallesPorFactura(id);
        boolean applyDiscount = haveDiscount(detalles);
        if(applyDiscount == true){
            for(Detalle detalle: detalles){
                Detalle nuevoDetalle = new Detalle();
                nuevoDetalle.setId(detalle.getId());
                nuevoDetalle.setCantidad(detalle.getCantidad());
                double nuevoPrecio = detalle.getPrecio() * (1-descuento);
                nuevoDetalle.setPrecio(nuevoPrecio);
                nuevoDetalle.setProducto(detalle.getProducto());
                detalleService.actualizarDetalle(detalle.getId(), nuevoDetalle);
            }
        }

    }
}

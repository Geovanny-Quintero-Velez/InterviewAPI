package com.example.interviewapi.repository;

import com.example.interviewapi.model.Detalle;
import com.example.interviewapi.model.DetalleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, DetalleId> {
    @Query("SELECT d FROM Detalle d WHERE d.id.id_factura = :num_factura")
    List<Detalle> finByFactura(@Param("num_factura") Long num_factura);
}

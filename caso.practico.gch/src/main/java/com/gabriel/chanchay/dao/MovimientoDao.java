package com.gabriel.chanchay.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gabriel.chanchay.modelo.Movimiento;

@Repository
public interface MovimientoDao extends JpaRepository<Movimiento, Long> {

	@Query("Select m.valor from movimiento m where m.id=?1")
	public BigDecimal obtenerSalado(Long idCuenta);

	@Query("Select m from movimiento m where m.cuenta.id=?1")
	public List<Movimiento> obtenerMovimientos(Long idCuenta);

	@Query("Select m from movimiento m where m.fecha>=:fechaDesde and m.fecha<=:fechaHasta and m.cuenta.persona.id=:idCliente ")
	public List<Movimiento> obtenerEstadoeCuenta(@Param(value = "fechaDesde") Date fechaDesde,
			@Param(value = "fechaHasta") Date fechaHasta, @Param(value = "idCliente") Long idPersona);
}

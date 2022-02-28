package com.gabriel.chanchay.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.chanchay.modelo.Movimiento;

public interface MovimientoDao extends JpaRepository<Movimiento, Integer> {
	
	BigDecimal obtenerSalado(Long idCuenta);

}

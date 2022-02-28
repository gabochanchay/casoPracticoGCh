package com.gabriel.chanchay.dao.impl;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.chanchay.dao.MovimientoDao;
import com.gabriel.chanchay.modelo.Movimiento;

public abstract class MovimientoDaoImpl implements JpaRepository<Movimiento, Integer>, MovimientoDao{
	
	@PersistenceContext()
	private EntityManager em;

	@Override
	public BigDecimal obtenerSalado(Long idCuenta) {
		// TODO Auto-generated method stub
		return null;
	}

}

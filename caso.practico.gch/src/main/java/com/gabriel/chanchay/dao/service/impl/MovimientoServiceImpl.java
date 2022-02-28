package com.gabriel.chanchay.dao.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.chanchay.dao.MovimientoDao;
import com.gabriel.chanchay.dao.service.MovimientoService;
import com.gabriel.chanchay.modelo.Movimiento;

@Service
public class MovimientoServiceImpl implements MovimientoService<Movimiento> {
	

	@Autowired
	private MovimientoDao movimientoDao;
	
	@Override
	public BigDecimal obtenerSaldo(Long idCuenta) {
		// TODO Auto-generated method stub
		return null;
	}

}

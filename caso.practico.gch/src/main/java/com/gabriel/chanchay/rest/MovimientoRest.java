package com.gabriel.chanchay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.chanchay.dao.MovimientoDao;
import com.gabriel.chanchay.modelo.Movimiento;

@RestController
@RequestMapping("movimiento")
public class MovimientoRest {

	@Autowired
	private MovimientoDao movimientoDao;

	@PostMapping("/guardar")
	public void crearMovimiento(@RequestBody Movimiento movimiento) {
		
		
		
		
		movimientoDao.save(movimiento);
	}

}

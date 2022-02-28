package com.gabriel.chanchay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.chanchay.dao.CuentaDao;
import com.gabriel.chanchay.modelo.Cuenta;

@RestController
@RequestMapping("cuentas")
public class CuentaRest {

	@Autowired
	private CuentaDao cuentaDao;

	@PostMapping("/guardar")
	public void crearCuenta(@RequestBody Cuenta cuenta) {
		cuentaDao.save(cuenta);
	}

}

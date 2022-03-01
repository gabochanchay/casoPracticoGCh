package com.gabriel.chanchay;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gabriel.chanchay.dao.CuentaDao;
import com.gabriel.chanchay.dao.servicio.CuentaServicio;
import com.gabriel.chanchay.modelo.Cuenta;
import com.gabriel.chanchay.modelo.Persona;

@SpringBootTest
class CuentaTest {

	@Autowired
	CuentaServicio cuentaServicio;

	@Autowired
	CuentaDao cuentaDao;

	@Test
	public void testCrearCuenta() {
		Cuenta c = new Cuenta();
		c.setEstado("S");
		Random r = new Random();
		int numCuenta = r.nextInt(9999);
		c.setNumeroCuenta(String.valueOf(numCuenta));
		Persona p = new Persona();
		p.setId((long) 5);
		c.setPersona(p);
		c.setSaldoInicial(BigDecimal.valueOf(4000));
		c.setTipoCuenta("Ahorros");
		c.setEstado("A");
		try {
			c = cuentaServicio.crear(c);
			assertNotNull(cuentaDao.findById(c.getId()).get());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

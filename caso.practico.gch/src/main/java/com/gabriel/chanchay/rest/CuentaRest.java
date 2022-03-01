package com.gabriel.chanchay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.chanchay.dao.servicio.CuentaServicio;
import com.gabriel.chanchay.modelo.Cuenta;

@RestController
@RequestMapping("cuentas")
public class CuentaRest {

	@Autowired
	private CuentaServicio cuentaService;

	@PostMapping("/crear")
	public ResponseEntity<?> crearCuenta(@RequestBody Cuenta cuenta) {
		try {
			cuentaService.crear(cuenta);
			return ResponseEntity.status(HttpStatus.OK).body(cuenta);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"error\":\"" + e.getMessage() + " \" }");
		}
	}

	@GetMapping("/buscar")
	public ResponseEntity<?> buscarPorId(@Param(value = "id") Long id) {
		try {
			Cuenta cuenta = cuentaService.buscarPorId(id);
			return ResponseEntity.status(HttpStatus.OK).body(cuenta);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"error\":\"" + e.getMessage() + " \" }");
		}
	}

	@DeleteMapping("/eliminar")
	public ResponseEntity<?> eliminar(@Param(value = "id") Long id) {
		try {
			boolean exito = cuentaService.eliminar(id);
			return ResponseEntity.status(HttpStatus.OK).body(exito);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"error\":\"" + e.getMessage() + " \" }");
		}
	}

	@GetMapping("/actualizar")
	public ResponseEntity<?> actualizarCuenta(@RequestBody Cuenta cuenta) {
		try {
			Cuenta cuentaAct=cuentaService.actualizar(cuenta.getId(), cuenta);
			return ResponseEntity.status(HttpStatus.OK).body(cuentaAct);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"error\":\"" + e.getMessage() + " \" }");
		}
	}

}

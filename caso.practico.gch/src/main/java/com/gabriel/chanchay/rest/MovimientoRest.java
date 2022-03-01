package com.gabriel.chanchay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.chanchay.dao.servicio.MovimientoServicio;
import com.gabriel.chanchay.modelo.Movimiento;

@RestController
@RequestMapping("movimiento")
public class MovimientoRest {

	@Autowired
	private MovimientoServicio movimientoServicio;

	@PostMapping("/crear")
	public ResponseEntity<?> crearMovimiento(@RequestBody Movimiento movimiento) {
		try {
			movimientoServicio.crearMovimiento(movimiento);
			return ResponseEntity.status(HttpStatus.OK).body(movimiento);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"error\":\"" + e.getMessage() + " \" }");
		}
	}

	@GetMapping("/buscar")
	public ResponseEntity<?> buscarPorId(@Param(value = "id") Long id) {
		try {
			Movimiento movimiento = movimientoServicio.buscarPorId(id);
			return ResponseEntity.status(HttpStatus.OK).body(movimiento);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"error\":\"" + e.getMessage() + " \" }");
		}
	}

	@DeleteMapping("/eliminar")
	public ResponseEntity<?> eliminar(@Param(value = "id") Long id) {
		try {
			boolean exito = movimientoServicio.eliminar(id);
			return ResponseEntity.status(HttpStatus.OK).body(exito);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"error\":\"" + e.getMessage() + " \" }");
		}
	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarCuenta(@RequestBody Movimiento movimiento) {
		try {
			Movimiento cuentaAct = movimientoServicio.actualizar(movimiento.getId(), movimiento);
			return ResponseEntity.status(HttpStatus.OK).body(cuentaAct);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"error\":\"" + e.getMessage() + " \" }");
		}
	}

}

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

import com.gabriel.chanchay.dao.servicio.ClienteServicio;
import com.gabriel.chanchay.modelo.Cliente;

@RestController
@RequestMapping("cliente")
public class ClienteRest {

	@Autowired
	private ClienteServicio clienteServicio;

	@PostMapping("/crear")
	public ResponseEntity<?> crearMovimiento(@RequestBody Cliente cliente) {
		try {
			clienteServicio.crear(cliente);
			return ResponseEntity.status(HttpStatus.OK).body(cliente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"error\":\"" + e.getMessage() + " \" }");
		}
	}

	@GetMapping("/buscar")
	public ResponseEntity<?> buscarPorId(@Param(value = "id") Long id) {
		try {
			Cliente cliente = clienteServicio.buscarPorId(id);
			return ResponseEntity.status(HttpStatus.OK).body(cliente);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"error\":\"" + e.getMessage() + " \" }");
		}
	}

	@DeleteMapping("/eliminar")
	public ResponseEntity<?> eliminar(@Param(value = "id") Long id) {
		try {
			boolean exito = clienteServicio.eliminar(id);
			return ResponseEntity.status(HttpStatus.OK).body(exito);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"error\":\"" + e.getMessage() + " \" }");
		}
	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarCuenta(@RequestBody Cliente cliente) {
		try {
			Cliente clienteAct = clienteServicio.actualizar(cliente.getId(), cliente);
			return ResponseEntity.status(HttpStatus.OK).body(clienteAct);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"error\":\"" + e.getMessage() + " \" }");
		}
	}

}

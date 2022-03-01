package com.gabriel.chanchay.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.chanchay.dao.servicio.MovimientoServicio;
import com.gabriel.chanchay.dto.EstadoDeCuentaMovimientoDto;

@RestController
@RequestMapping("reportes")
public class ReportesRest {

	@Autowired
	private MovimientoServicio movimientoService;

	@GetMapping("/estadoDeCuenta")
	public ResponseEntity<?> crearMovimiento(@Param(value = "fechaDesde") String fechaDesde,
			@Param(value = "fechaHasta") String fechaHasta, @Param(value = "idCliente") Long idCliente) {
		try {
			Date fechaDesdeDate = new SimpleDateFormat("yyyy-MM-dd").parse(fechaDesde);
			Date fechahastaDate = new SimpleDateFormat("yyyy-MM-dd").parse(fechaHasta);
			List<EstadoDeCuentaMovimientoDto> lista = movimientoService.obtenerEstadoeCuentaDto(fechaDesdeDate,
					fechahastaDate, idCliente);
			return ResponseEntity.status(HttpStatus.OK).body(lista);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"error\":\"" + e.getMessage() + " \" }");
		}
	}

}

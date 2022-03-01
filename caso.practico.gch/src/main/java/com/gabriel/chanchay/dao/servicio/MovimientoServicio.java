package com.gabriel.chanchay.dao.servicio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gabriel.chanchay.dto.EstadoDeCuentaMovimientoDto;
import com.gabriel.chanchay.modelo.Cuenta;
import com.gabriel.chanchay.modelo.Movimiento;

@Service
public interface MovimientoServicio {
	
	public Movimiento buscarPorId(Long id) throws Exception;

	boolean eliminar(Long id) throws Exception;

	Movimiento actualizar(Long id, Movimiento movimientoActualizar) throws Exception;

	BigDecimal obtenerSaldo(Long idCuenta);
	
	public List<Movimiento> obtenerMovimientos(Long idCuenta);
	
	public void crearMovimiento(Movimiento movimiento) throws Exception;
	
	public List<Movimiento> obtenerEstadoeCuenta(Date fechaDesde, Date fechaHasta,Long idPersona);
	
	public List<EstadoDeCuentaMovimientoDto> obtenerEstadoeCuentaDto(Date fechaDesde, Date fechaHasta,Long idPersona);

}

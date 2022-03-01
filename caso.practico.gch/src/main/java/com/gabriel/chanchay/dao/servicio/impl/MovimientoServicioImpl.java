package com.gabriel.chanchay.dao.servicio.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.chanchay.dao.MovimientoDao;
import com.gabriel.chanchay.dao.servicio.CuentaServicio;
import com.gabriel.chanchay.dao.servicio.MovimientoServicio;
import com.gabriel.chanchay.dto.EstadoDeCuentaMovimientoDto;
import com.gabriel.chanchay.modelo.Cuenta;
import com.gabriel.chanchay.modelo.Movimiento;

@Service
public class MovimientoServicioImpl implements MovimientoServicio {

//	private static BigDecimal limiteDiario = BigDecimal.valueOf(1000);

	@Autowired
	private MovimientoDao movimientoDao;

	@Autowired
	private CuentaServicio cuentaService;

	@Override
	public BigDecimal obtenerSaldo(Long idCuenta) {
		return movimientoDao.obtenerSalado(idCuenta);
	}

	@Override
	public List<Movimiento> obtenerMovimientos(Long idCuenta) {
		return movimientoDao.obtenerMovimientos(idCuenta);
	}

	@Override
	public void crearMovimiento(Movimiento movimiento) throws Exception {
		Cuenta cuenta = cuentaService.buscarPorId(movimiento.getCuenta().getId());
		List<Movimiento> movimientos = movimientoDao.obtenerMovimientos(movimiento.getCuenta().getId());
		BigDecimal saldo = BigDecimal.ZERO;
		if (!movimientos.isEmpty()) {
			Collections.sort(movimientos, new Comparator<Movimiento>() {
				@Override
				public int compare(Movimiento u1, Movimiento u2) {
					return u1.getFecha().compareTo(u2.getFecha());
				}
			});
			int indiceUltimoMovimiento = movimientos.size() - 1;
			Movimiento ultimoMovimiento = movimientos.get(indiceUltimoMovimiento);
			saldo = ultimoMovimiento.getSaldo();

			if (saldo.compareTo(BigDecimal.ZERO) == 0) {
				throw new Exception("Saldo no disponible");
			}
			System.out.println("saldoooooooooooo:" + saldo);
			BigDecimal nuevoSaldo = saldo.add(movimiento.getValor());
			if (nuevoSaldo.compareTo(BigDecimal.ZERO) == -1) {
				throw new Exception("Su saldo no es suficiente para realizar esta transaccion");
			}
			movimiento.setSaldo(saldo.add(movimiento.getValor()));
		} else {
			saldo = movimiento.getValor();
			movimiento.setSaldo(cuenta.getSaldoInicial().add(saldo));
		}
		movimiento.setFecha(new Date());
		movimientoDao.save(movimiento);
	}

	@Override
	public List<Movimiento> obtenerEstadoeCuenta(Date fechaDesde, Date fechaHasta, Long idPersona) {
		return movimientoDao.obtenerEstadoeCuenta(fechaDesde, fechaHasta, idPersona);
	}

	@Override
	public List<EstadoDeCuentaMovimientoDto> obtenerEstadoeCuentaDto(Date fechaDesde, Date fechaHasta, Long idPersona) {
		List<Movimiento> lista = this.obtenerEstadoeCuenta(fechaDesde, fechaHasta, idPersona);
		List<EstadoDeCuentaMovimientoDto> listaDto = new ArrayList<EstadoDeCuentaMovimientoDto>();
		for (Movimiento m : lista) {
			EstadoDeCuentaMovimientoDto dto = new EstadoDeCuentaMovimientoDto();
			dto.setFecha(m.getFecha());
			dto.setCliente(m.getCuenta().getPersona().getNombre());
			dto.setNumeroDeCuenta(m.getCuenta().getNumeroCuenta());
			dto.setTipo(m.getTipoMovimiento());
			dto.setSaldoInicial(m.getCuenta().getSaldoInicial());
			dto.setMovimiento(m.getValor());
			dto.setSaldoDisponible(m.getSaldo());
			listaDto.add(dto);
		}
		return listaDto;
	}

	@Override
	public Movimiento buscarPorId(Long id) throws Exception {
		try {
			Optional<Movimiento> movOptional = movimientoDao.findById(id);
			return movOptional.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public boolean eliminar(Long id) throws Exception {
		try {
			if (movimientoDao.existsById(id)) {
				movimientoDao.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Movimiento actualizar(Long id, Movimiento movimientoActualizar) throws Exception {
		try {
			Optional<Movimiento> movOptional = movimientoDao.findById(id);
			Movimiento movimiento = movOptional.get();
			movimiento = movimientoDao.save(movimientoActualizar);
			return movimiento;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}

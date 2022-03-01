package com.gabriel.chanchay.dao.servicio.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.chanchay.dao.CuentaDao;
import com.gabriel.chanchay.dao.servicio.CuentaServicio;
import com.gabriel.chanchay.modelo.Cuenta;

@Service
public class CuentaServicioImpl implements CuentaServicio {

	@Autowired
	private CuentaDao cuentaDao;

	@Override
	public Cuenta buscarPorId(Long id) throws Exception {
		try {
			Optional<Cuenta> cuentaOptional = cuentaDao.findById(id);
			return cuentaOptional.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Cuenta crear(Cuenta cuenta) throws Exception {
		try {
			cuenta = cuentaDao.save(cuenta);
			return cuenta;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Cuenta actualizar(Long id, Cuenta cuentaActualizar) throws Exception {
		try {
			Optional<Cuenta> cuentaOptional = cuentaDao.findById(id);
			Cuenta cuenta = cuentaOptional.get();
			cuenta = cuentaDao.save(cuentaActualizar);
			return cuenta;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public boolean eliminar(Long id) throws Exception {
		try {
			if (cuentaDao.existsById(id)) {
				cuentaDao.deleteById(id);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}

package com.gabriel.chanchay.dao.servicio;

import org.springframework.stereotype.Service;

import com.gabriel.chanchay.modelo.Cuenta;

@Service
public interface CuentaServicio {

	public Cuenta buscarPorId(Long id) throws Exception;

	boolean eliminar(Long id) throws Exception;

	public Cuenta crear(Cuenta cuenta) throws Exception;

	Cuenta actualizar(Long id, Cuenta cuentaActualizar) throws Exception;

}

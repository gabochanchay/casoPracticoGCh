package com.gabriel.chanchay.dao.servicio.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.chanchay.dao.ClienteDao;
import com.gabriel.chanchay.dao.servicio.ClienteServicio;
import com.gabriel.chanchay.modelo.Cliente;

@Service
public class ClienteServicioImpl implements ClienteServicio {

	@Autowired
	private ClienteDao clienteDao;

	@Override
	public Cliente buscarPorId(Long id) throws Exception {
		try {
			Optional<Cliente> cuentaOptional = clienteDao.findById(id);
			return cuentaOptional.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Cliente crear(Cliente cuenta) throws Exception {
		try {
			cuenta = clienteDao.save(cuenta);
			return cuenta;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Cliente actualizar(Long id, Cliente clienteActualizar) throws Exception {
		try {
			Optional<Cliente> cuentaOptional = clienteDao.findById(id);
			Cliente cliente = cuentaOptional.get();
			cliente = clienteDao.save(clienteActualizar);
			return cliente;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public boolean eliminar(Long id) throws Exception {
		try {
			if (clienteDao.existsById(id)) {
				clienteDao.deleteById(id);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}

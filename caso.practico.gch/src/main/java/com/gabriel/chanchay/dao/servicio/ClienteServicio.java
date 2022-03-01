package com.gabriel.chanchay.dao.servicio;

import org.springframework.stereotype.Service;

import com.gabriel.chanchay.modelo.Cliente;

@Service
public interface ClienteServicio {

	public Cliente buscarPorId(Long id) throws Exception;

	boolean eliminar(Long id) throws Exception;

	public Cliente crear(Cliente cliente) throws Exception;

	Cliente actualizar(Long id, Cliente clienteActualizar) throws Exception;

}

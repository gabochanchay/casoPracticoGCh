package com.gabriel.chanchay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.chanchay.dao.ClienteDao;
import com.gabriel.chanchay.modelo.Cliente;

@RestController
@RequestMapping("cliente")
public class ClienteRest {

	@Autowired
	private ClienteDao clienteDao;

	@PostMapping("/guardar")
	public void crearCliente(@RequestBody Cliente cliente) {
		clienteDao.save(cliente);
	}

}

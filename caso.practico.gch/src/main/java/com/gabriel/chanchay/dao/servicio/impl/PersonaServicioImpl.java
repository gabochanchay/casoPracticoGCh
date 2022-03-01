package com.gabriel.chanchay.dao.servicio.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.chanchay.dao.PersonaDao;
import com.gabriel.chanchay.dao.servicio.PersonaServicio;
import com.gabriel.chanchay.modelo.Persona;

@Service
public class PersonaServicioImpl implements PersonaServicio {

	@Autowired
	private PersonaDao personaDao;

	@Override
	public Persona buscarPorId(Long id) throws Exception {
		try {
			Optional<Persona> cuentaOptional = personaDao.findById(id);
			return cuentaOptional.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Persona crear(Persona persona) throws Exception {
		try {
			persona = personaDao.save(persona);
			return persona;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Persona actualizar(Long id, Persona personaActualizar) throws Exception {
		try {
			Optional<Persona> personaOptional = personaDao.findById(id);
			Persona persona = personaOptional.get();
			persona = personaDao.save(persona);
			return persona;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public boolean eliminar(Long id) throws Exception {
		try {
			if (personaDao.existsById(id)) {
				personaDao.deleteById(id);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}

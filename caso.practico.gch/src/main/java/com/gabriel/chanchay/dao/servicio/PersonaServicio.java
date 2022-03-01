package com.gabriel.chanchay.dao.servicio;

import org.springframework.stereotype.Service;

import com.gabriel.chanchay.modelo.Persona;

@Service
public interface PersonaServicio {

	public Persona buscarPorId(Long id) throws Exception;

	public Persona crear(Persona persona) throws Exception;

	boolean eliminar(Long id) throws Exception;

	Persona actualizar(Long id, Persona personaActualizar) throws Exception;

}

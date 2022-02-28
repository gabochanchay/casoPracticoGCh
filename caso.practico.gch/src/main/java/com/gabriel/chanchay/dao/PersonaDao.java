package com.gabriel.chanchay.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gabriel.chanchay.modelo.Persona;

public interface PersonaDao extends JpaRepository<Persona, Integer>{

}

package com.gabriel.chanchay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.chanchay.modelo.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Integer> {

}

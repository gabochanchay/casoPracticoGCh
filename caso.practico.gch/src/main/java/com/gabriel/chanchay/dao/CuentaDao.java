package com.gabriel.chanchay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.chanchay.modelo.Cuenta;

public interface CuentaDao extends JpaRepository<Cuenta, Integer> {

}

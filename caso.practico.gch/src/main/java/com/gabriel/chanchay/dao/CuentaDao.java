package com.gabriel.chanchay.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gabriel.chanchay.modelo.Cuenta;

@Repository
public interface CuentaDao extends JpaRepository<Cuenta, Long> {

}

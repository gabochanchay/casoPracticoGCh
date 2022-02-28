package com.gabriel.chanchay.dao.service;

import java.math.BigDecimal;

public interface MovimientoService<E> {

	BigDecimal obtenerSaldo(Long idCuenta);

}

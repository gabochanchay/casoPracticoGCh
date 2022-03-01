package com.gabriel.chanchay.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EstadoDeCuentaMovimientoDto implements Serializable {

	private static final long serialVersionUID = 1027285110626632080L;
	private Date fecha;
	private String cliente;
	private String numeroDeCuenta;
	private String tipo;
	private BigDecimal saldoInicial;
	private boolean estado;
	private BigDecimal movimiento;
	private BigDecimal saldoDisponible;
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getNumeroDeCuenta() {
		return numeroDeCuenta;
	}
	public void setNumeroDeCuenta(String numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getSaldoInicial() {
		return saldoInicial;
	}
	public void setSaldoInicial(BigDecimal saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public BigDecimal getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(BigDecimal movimiento) {
		this.movimiento = movimiento;
	}
	public BigDecimal getSaldoDisponible() {
		return saldoDisponible;
	}
	public void setSaldoDisponible(BigDecimal saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}

	
}

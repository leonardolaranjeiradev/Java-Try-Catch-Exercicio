package entities;

import exceptions.BusinessExceptions;

public class Conta {
	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteDeSaque;

	public Conta() {
	}

	public Conta(Integer numero, String titular, Double saldo, Double limiteDeSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteDeSaque = limiteDeSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteDeSaque() {
		return limiteDeSaque;
	}

	public void setLimiteDeSaque(Double limiteDeSaque) {
		this.limiteDeSaque = limiteDeSaque;
	}
	
	public void deposito(double quantia) {
		saldo += quantia;
	}
	
	public void saque(double quantia) {
		validacaoDeSaque(quantia);
		saldo -= quantia;
	}
	
	public void validacaoDeSaque(double quantia) {
		if (quantia > getLimiteDeSaque()) {
			throw new BusinessExceptions("Erro de saque: o valor excede o limite de saque");
		}
		
		if (quantia > getSaldo()) {
			throw new BusinessExceptions("Erro de saque: saldo insuficiente");
			
		}
	}
}

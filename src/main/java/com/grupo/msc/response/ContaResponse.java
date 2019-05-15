package com.grupo.msc.response;

public class ContaResponse {

	private String nomeTitular;
	private Double saldo;
	private Long numeroConta;
	
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Long getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(Long numeroConta) {
		this.numeroConta = numeroConta;
	}
	@Override
	public String toString() {
		return "ContaResponse [nomeTitular=" + nomeTitular + ", saldo=" + saldo + ", numeroConta=" + numeroConta + "]";
	}
	
}

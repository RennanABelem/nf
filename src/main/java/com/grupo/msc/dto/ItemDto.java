package com.grupo.msc.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ItemDto {

	@NotEmpty(message = "O campo [NOME], não pode ser nulo.")
	private String nome;
	@NotNull(message = "O campo [VALOR], não pode ser nulo.")
	private Double valor;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}

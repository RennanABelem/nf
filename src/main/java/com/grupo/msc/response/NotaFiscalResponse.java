package com.grupo.msc.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.grupo.msc.model.ItemDaNota;
import com.grupo.msc.model.NotaFiscal;

public class NotaFiscalResponse {

	private Long numero;
	private Map<String, Double> itens;
	private Double valorTotal;
	private String nomeTitular;

	public NotaFiscalResponse(NotaFiscal notaFiscal) {
		this.numero = notaFiscal.getNumero();
		this.valorTotal = notaFiscal.getValorTotal();
		this.nomeTitular = notaFiscal.getNomeTitular();
		this.itens = new HashMap<String, Double>();
		
		for (ItemDaNota item : notaFiscal.getItens()) {
			this.itens.put(item.getNome(), item.getValor());
		}

	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Map<String, Double> getItens() {
		return itens;
	}

	public void setItens(Map<String, Double> itens) {
		this.itens = itens;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

}

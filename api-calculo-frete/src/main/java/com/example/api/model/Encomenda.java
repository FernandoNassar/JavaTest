package com.example.api.model;

import java.math.BigDecimal;

public class Encomenda {
	
	private BigDecimal peso;
	private Cep cepOrigem;
	private Cep cepDestino;
	private String nomeDestinatario;
	
	public Encomenda() { }
	
	public Encomenda(BigDecimal peso, Cep cepOrigem, Cep cepDestino, String nomeDestinatario) {
		this.peso = peso;
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
	}

	public BigDecimal getPeso() {
		return peso;
	}
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}
	public Cep getCepOrigem() {
		return cepOrigem;
	}
	public void setCepOrigem(Cep cepOrigem) {
		this.cepOrigem = cepOrigem;
	}
	public Cep getCepDestino() {
		return cepDestino;
	}
	public void setCepDestino(Cep cepDestino) {
		this.cepDestino = cepDestino;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}
}

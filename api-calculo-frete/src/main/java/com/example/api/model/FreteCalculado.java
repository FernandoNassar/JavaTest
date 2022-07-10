package com.example.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FreteCalculado {
	
	private BigDecimal vlTotalFrete;
	private LocalDate dataPrevistaEntrega;
	private Cep cepOrigem;
	private Cep cepDestino;
	
	public FreteCalculado() {}
	
	public FreteCalculado(BigDecimal vlTotalFrete, LocalDate dataPrevistaEntrega, Cep cepOrigem, Cep cepDestino) {
		this.vlTotalFrete = vlTotalFrete;
		this.dataPrevistaEntrega = dataPrevistaEntrega;
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
	}
	
	
	public BigDecimal getVlTotalFrete() {
		return vlTotalFrete;
	}
	public void setVlTotalFrete(BigDecimal vlTotalFrete) {
		this.vlTotalFrete = vlTotalFrete;
	}
	public LocalDate getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}
	public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}
	public Cep getCepDestino() {
		return cepDestino;
	}
	public void setCepDestino(Cep cepDestino) {
		this.cepDestino = cepDestino;
	}

	public Cep getCepOrigem() {
		return cepOrigem;
	}

	public void setCepOrigem(Cep cepOrigem) {
		this.cepOrigem = cepOrigem;
	}
	
}

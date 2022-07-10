package com.example.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Consulta {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal peso;
	private String cepOrigem;
	private String cepDestino;
	private String nomeDestinatario;
	private BigDecimal vlTotalFrete;
	private LocalDate dataPrevistaEntrega;
	private LocalDate dataConsulta = LocalDate.now();
	
	
	public BigDecimal getPeso() {
		return peso;
	}
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}
	public String getCepOrigem() {
		return cepOrigem;
	}
	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}
	public String getCepDestino() {
		return cepDestino;
	}
	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}
	public String getNomeDestinatario() {
		return nomeDestinatario;
	}
	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
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
	public LocalDate getDataConsulta() {
		return dataConsulta;
	}
}

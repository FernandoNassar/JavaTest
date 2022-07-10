package com.example.api.model;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class InputEncomenda {
	@NotNull @Min(value = 0)
	private BigDecimal peso;
	@Pattern(regexp = "[0-9]{8}", message = "CEP inválido")
	private String cepOrigem;
	@Pattern(regexp = "[0-9]{8}", message = "CEP inválido")
	private String cepDestino;
	@NotBlank
	private String nomeDestinatario;
	
	public InputEncomenda() {}
	
	public InputEncomenda(BigDecimal peso, String cepOrigem, String cepDestino, String nomeDestinatario) {
		this.peso = peso;
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
		this.nomeDestinatario = nomeDestinatario;
	}
	
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
}

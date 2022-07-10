package com.example.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.calculo.CalculoDeFrete;
import com.example.api.calculo.CalculoPadrao;
import com.example.api.client.CepHttpClient;
import com.example.api.model.Cep;
import com.example.api.model.Encomenda;
import com.example.api.model.FreteCalculado;
import com.example.api.model.InputEncomenda;

@Service
public class FreteService {
	
	@Autowired
	private CepHttpClient cepHttpClient;
	
	private final CalculoDeFrete calculoDeFrete = new CalculoPadrao();
	
	
	public FreteCalculado calcularFrete(InputEncomenda input) {
		var encomenda = criarEncomenda(input);
		return calculoDeFrete.calcular(encomenda);
	}
	
	
	public Encomenda criarEncomenda(InputEncomenda input) {
		return new Encomenda(
				input.getPeso(),
				buscarCep(input.getCepOrigem()),
				buscarCep(input.getCepDestino()),
				input.getNomeDestinatario());
	}	
	
	public Cep buscarCep(String cep) {
		Cep cepConsultado = cepHttpClient.consultarCep(cep).orElseThrow(()-> new RuntimeException(mensagemDeErroCep(cep)));		
		if (cepConsultado.getCep() == null) throw new RuntimeException(mensagemDeErroCep(cep));	
		return cepConsultado;
	}
	
	private String mensagemDeErroCep(String cep) {
		return "não foi possível consultar o CEP: " + cep;
	}
}







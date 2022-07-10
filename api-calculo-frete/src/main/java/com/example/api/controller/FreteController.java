package com.example.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.Cep;
import com.example.api.model.FreteCalculado;
import com.example.api.model.InputEncomenda;
import com.example.api.service.ConsultaService;
import com.example.api.service.FreteService;


@RestController
@RequestMapping("/api/frete")
public class FreteController {
	
	@Autowired
	private ConsultaService consultaService;
	
	@Autowired
	private FreteService freteService;
	
	
	@GetMapping("/{cep}")
	public Cep consultarCep(@PathVariable("cep") String cep) {
		return freteService.buscarCep(cep);
	}
	
	
	
	@PostMapping("/valor")
	public FreteCalculado valorDoFrete(@RequestBody @Valid InputEncomenda input) {

		var freteCalculado = freteService.calcularFrete(input);
				
		consultaService.salvarConsulta(input, freteCalculado);
		
		return freteCalculado;
	}
}

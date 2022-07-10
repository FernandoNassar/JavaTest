package com.example.api.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.api.model.Cep;

@FeignClient(name = "cep", url = "https://viacep.com.br/ws")
public interface CepHttpClient {
	
	@GetMapping("/{cep}/json")
	Optional<Cep> consultarCep(@PathVariable("cep") String cep);
	
}

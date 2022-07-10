package com.example.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.api.model.FreteCalculado;
import com.example.api.model.InputEncomenda;
import com.example.entity.Consulta;
import com.example.repository.ConsultaRepository;

@Service
public class ConsultaService {
	
	private final ConsultaRepository consultaRepository;
	
	public ConsultaService(ConsultaRepository consultaRepository) {
		this.consultaRepository = consultaRepository;
	}
	
	public Page<Consulta> findAll(Pageable pageable) {
		return consultaRepository.findAll(pageable);
	}
	
	public Consulta salvarConsulta(InputEncomenda encomenda, FreteCalculado freteCalculado) {
		var consulta = new Consulta();
		consulta.setPeso(encomenda.getPeso());
		consulta.setCepOrigem(encomenda.getCepOrigem());
		consulta.setCepDestino(encomenda.getCepDestino());
		consulta.setNomeDestinatario(encomenda.getNomeDestinatario());
		consulta.setVlTotalFrete(freteCalculado.getVlTotalFrete());
		consulta.setDataPrevistaEntrega(freteCalculado.getDataPrevistaEntrega());
		
		return consultaRepository.save(consulta);
	}
	
}	

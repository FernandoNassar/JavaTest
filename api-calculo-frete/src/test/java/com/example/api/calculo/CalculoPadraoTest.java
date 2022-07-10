package com.example.api.calculo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.api.model.InputEncomenda;
import com.example.api.service.FreteService;


@SpringBootTest
public class CalculoPadraoTest {
	
	@Autowired
	private FreteService freteService;
	
	private InputEncomenda mesmoDDD = new InputEncomenda(new BigDecimal("100.0"), "23555200", "22715140", "_");
	private InputEncomenda mesmoEstadoDddDiferente = new InputEncomenda(new BigDecimal("100.0"), "23937060", "22715140", "_");
	private InputEncomenda estadosDiferentes = new InputEncomenda(new BigDecimal("100.0"), "41710200", "22715140", "_");
	
	@Test
	public void dddsSaoIguais() {
		var encomenda = freteService.criarEncomenda(mesmoDDD);
		assertEquals(encomenda.getCepOrigem().getDdd(), encomenda.getCepDestino().getDdd());
	}
	
	@Test
	public void mesmaUfDddDiferente() {
		var encomenda = freteService.criarEncomenda(mesmoEstadoDddDiferente);
		assertNotEquals(encomenda.getCepOrigem().getDdd(), encomenda.getCepDestino().getDdd());
		assertEquals(encomenda.getCepOrigem().getUf(), encomenda.getCepDestino().getUf());
	}
	
	@Test
	public void estadosDiferentes() {
		var encomenda = freteService.criarEncomenda(estadosDiferentes);
		assertNotEquals(encomenda.getCepOrigem().getUf(), encomenda.getCepDestino().getUf());
	}
	
	@Test
	public void descontoDeveSerDe75PorCentoParaDddsDiferentesEEstadosIguais() {
		var freteCalculado = freteService.calcularFrete(mesmoEstadoDddDiferente);
		assertEquals(freteCalculado.getVlTotalFrete(), mesmoEstadoDddDiferente.getPeso().multiply(new BigDecimal("0.25")));
	}
	
	@Test
	public void descontoDeveSerDe50PorCentoParaDddsIguais() {
		var freteCalculado = freteService.calcularFrete(mesmoDDD);
		assertEquals(freteCalculado.getVlTotalFrete(), mesmoDDD.getPeso().multiply(new BigDecimal("0.5")));
	}
	
	@Test
	public void semDescontoParaUFsDiferentes() {
		var freteCalculado = freteService.calcularFrete(estadosDiferentes);
		var vlTotalFrete = freteCalculado.getVlTotalFrete();
		assertEquals(vlTotalFrete, estadosDiferentes.getPeso().multiply(BigDecimal.ONE));
	}	
	
	@Test
	public void prazoDeEntregaDeveSerDe1DiaParaMesmoDDD() {
		var freteCalculado = freteService.calcularFrete(mesmoDDD);
		assertEquals(freteCalculado.getDataPrevistaEntrega(), LocalDate.now().plusDays(1));
	}
	
	@Test
	public void prazoDeEntregaDeveSerDe3DiaParaEstadosIguaisEDddsDiferentes() {
		var freteCalculado = freteService.calcularFrete(mesmoEstadoDddDiferente);
		assertEquals(freteCalculado.getDataPrevistaEntrega(), LocalDate.now().plusDays(3));
	}
	
	@Test
	public void prazoDeEntregaDeveSerDe10DiasParaEstadosDiferentes() {
		var freteCalculado = freteService.calcularFrete(estadosDiferentes);
		assertEquals(freteCalculado.getDataPrevistaEntrega(), LocalDate.now().plusDays(10));
	}
	
}

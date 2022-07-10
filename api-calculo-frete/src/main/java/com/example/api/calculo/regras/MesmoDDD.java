package com.example.api.calculo.regras;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.api.model.Encomenda;
import com.example.api.model.FreteCalculado;

public class MesmoDDD implements RegraDeCalculo {
	
	private static final BigDecimal PERCENTUAL_DE_DESCONTO = new BigDecimal("0.5");
	
	private final RegraDeCalculo proximoCalculo;
	

	public MesmoDDD(RegraDeCalculo proximoCalculo) {
		this.proximoCalculo = proximoCalculo;
	}


	@Override
	public FreteCalculado calcularFrete(Encomenda encomenda) {
		if (encomenda.getCepOrigem().getDdd().equals(encomenda.getCepDestino().getDdd())) {
			var valor = calcularValorTotal(encomenda.getPeso());
			return new FreteCalculado(valor, calcularDataDeEntrega(), encomenda.getCepOrigem(), encomenda.getCepDestino());
		}
		return proximoCalculo.calcularFrete(encomenda);
	}

	
	@Override
	public BigDecimal getValorPorPesoComDesconto() {
		return VALOR_POR_PESO.subtract(PERCENTUAL_DE_DESCONTO);
	}


	@Override
	public LocalDate calcularDataDeEntrega() {
		return LocalDate.now().plusDays(1L);
	}
	
	private BigDecimal calcularValorTotal(BigDecimal peso) {
		return peso.multiply(VALOR_POR_PESO).multiply(getValorPorPesoComDesconto());
	}

}

package com.example.api.calculo.regras;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.api.model.Encomenda;
import com.example.api.model.FreteCalculado;

public class MesmoEstado implements RegraDeCalculo {
	
	private static final BigDecimal PERCENTUAL_DE_DESCONTO = new BigDecimal("0.75");
	
	private final RegraDeCalculo proximoCalculo;
	
	public MesmoEstado(RegraDeCalculo proximoCalculo) {
		this.proximoCalculo = proximoCalculo;
	}

	
	
	@Override
	public FreteCalculado calcularFrete(Encomenda encomenda) {
		if (encomenda.getCepOrigem().getUf().equals(encomenda.getCepDestino().getUf())) {
			var valor = encomenda.getPeso().multiply(new BigDecimal("0.25"));
			return new FreteCalculado(valor, LocalDate.now().plusDays(3L), encomenda.getCepOrigem(), encomenda.getCepDestino());
		}
		return proximoCalculo.calcularFrete(encomenda);
	}

	
	
	@Override
	public BigDecimal getValorPorPesoComDesconto() {
		return VALOR_POR_PESO.subtract(PERCENTUAL_DE_DESCONTO);
	}

	@Override
	public LocalDate calcularDataDeEntrega() {
		return LocalDate.now().plusDays(3L);
	}

}

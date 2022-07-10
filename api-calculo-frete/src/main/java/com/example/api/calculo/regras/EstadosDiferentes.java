package com.example.api.calculo.regras;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.api.model.Encomenda;
import com.example.api.model.FreteCalculado;

public class EstadosDiferentes implements RegraDeCalculo {

	@Override
	public FreteCalculado calcularFrete(Encomenda encomenda) {
		return new FreteCalculado(encomenda.getPeso(), LocalDate.now().plusDays(10L), encomenda.getCepOrigem(), encomenda.getCepDestino());
	}

	public BigDecimal getValorComDesconto() {
		return BigDecimal.ONE;
	}

	@Override
	public BigDecimal getValorPorPesoComDesconto() {
		return VALOR_POR_PESO;
	}

	@Override
	public LocalDate calcularDataDeEntrega() {
		return LocalDate.now().plusDays(PRAZO_PADRAO_DE_ENTREGA);
	}
	
}

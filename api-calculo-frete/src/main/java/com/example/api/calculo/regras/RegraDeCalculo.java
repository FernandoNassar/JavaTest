package com.example.api.calculo.regras;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.api.model.Encomenda;
import com.example.api.model.FreteCalculado;

public interface RegraDeCalculo {
	
	BigDecimal VALOR_POR_PESO = BigDecimal.ONE;
	Long PRAZO_PADRAO_DE_ENTREGA = 10L;
	
	FreteCalculado calcularFrete(Encomenda encomenda);
	
	BigDecimal getValorPorPesoComDesconto();
	
	LocalDate calcularDataDeEntrega();
}

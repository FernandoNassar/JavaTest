package com.example.api.calculo;

import com.example.api.calculo.regras.EstadosDiferentes;
import com.example.api.calculo.regras.MesmoDDD;
import com.example.api.calculo.regras.MesmoEstado;
import com.example.api.model.Encomenda;
import com.example.api.model.FreteCalculado;

public class CalculoPadrao implements CalculoDeFrete {

	@Override
	public FreteCalculado calcular(Encomenda encomenda) {
		return new MesmoDDD(new MesmoEstado(new EstadosDiferentes()))
				.calcularFrete(encomenda);
	}

}

package com.example.api.calculo;

import com.example.api.model.Encomenda;
import com.example.api.model.FreteCalculado;

public interface CalculoDeFrete {
	
	FreteCalculado calcular(Encomenda encomenda);

}

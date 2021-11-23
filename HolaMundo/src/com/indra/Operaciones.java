package com.indra;

import java.math.BigDecimal;

import com.indra.util.MasOperaciones;

public class Operaciones extends MasOperaciones {

	static BigDecimal multiplicar(BigDecimal b1, BigDecimal b2, BigDecimal b3) {
		return b1.multiply(b2).multiply(b3);
	}

	static BigDecimal prueba(BigDecimal b1, BigDecimal b2, BigDecimal b3) {
		return division(b1, b2, b3).orElseGet(() -> new BigDecimal(0));
	}
	
}

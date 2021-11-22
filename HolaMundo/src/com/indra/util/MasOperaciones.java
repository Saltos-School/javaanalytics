package com.indra.util;

import java.math.BigDecimal;

public class MasOperaciones {

	protected static BigDecimal division(BigDecimal b1, BigDecimal b2, BigDecimal b3) {
		try {
			return b1.divide(b2).divide(b3);
		} catch (ArithmeticException e) {
			System.err.println("Error al dividir: " + e.getMessage());
			return null;
		}
	}

}

package com.indra.util;

import java.math.BigDecimal;
import java.util.Optional;

public class MasOperaciones {

	protected static Optional<BigDecimal> division(BigDecimal b1, BigDecimal b2, BigDecimal b3) {
		try {
			return Optional.ofNullable(b1.divide(b2).divide(b3));
		} catch (ArithmeticException e) {
			System.err.println("Error al dividir: " + e.getMessage());
			return Optional.empty();
		}
	}

}

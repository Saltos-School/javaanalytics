package com.indra;

import java.math.BigDecimal;

public class HolaMundoApp {
	// https://github.com/Saltos-School/javaanalytics
	public static void main(String[] args) {
		System.out.println("Hola Mundo");
		int a = 0;
		double n = 200.598795;
		System.out.println("La variable a es " + a);
		System.out.println("La variable n es " + n);
		double x = 0.1;
		double y = 0.2;
		double z = 0.3;
		double suma = x + y + z;
		System.out.println("x + y + z = " + suma);
		long b = 20000000000L;
		float i = 0.1F;
		float j = 0.2F;
		float k = 0.3F;
		float suma2 = i + j + k;
		System.out.println("b = " + b);
		System.out.println("i + j + k = " + suma2);
		
		System.out.println("max int = " + Integer.MAX_VALUE);
		System.out.println("max long = " + Long.MAX_VALUE);
		
		BigDecimal b1 = new BigDecimal("100.4567");
		BigDecimal b2 = new BigDecimal("200.2345");
		BigDecimal suma3 = b1.add(b2);
		System.out.println("b1 + b2 = " + suma3);
		BigDecimal resultado = b1.multiply(b2);
		System.out.println("b1 x b2 = " + resultado);
		
		BigDecimal bi = new BigDecimal("0.1");
		BigDecimal bj = new BigDecimal("0.2");
		BigDecimal bk = new BigDecimal("0.3");
		BigDecimal suma4 = bi.add(bj).add(bk);
		System.out.println("bi + bj + bk = " + suma4);
	}

}

package com.indra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Colecciones {

	public static void main(String[] args) {
		int a = 20;
		
		Integer i = 50;
		
		int b = i;
		
		BigDecimal d = new BigDecimal(39);
		
		Optional<Integer> oi = Optional.ofNullable(25);
		
		int[] v = { 1, 2, 5, -1, 80, 15 };
		
		int v2[] = { 1, 5, -9, 11 };
		
		int[] v3 = new int[3];
		v3[0] = 1;
		v3[1] = -5;
		v3[2] = 7;
		
		List<Integer> l = Arrays.asList(5, 7, -3);
		
		List<Integer> l2 = new ArrayList<>();
		l2.add(5);
		l2.add(7);
		l2.add(-3);
				
		System.out.println("b = " + b);
		System.out.println("oi = " + oi);
		System.out.println("v = " + v);
		System.out.println("l2 = " + l2);
		System.out.println("s1 = " + openStream());
		
		System.out.println("v =");
		for (int j = 0; j < v.length; j++) {
			System.out.println(v[j]);
		}
		
		System.out.println("l = ");
		for (int k = 0; k < l.size(); k++) {
			System.out.println(l.get(k));
		}
		
		System.out.println("l2 = ");
		for (Integer x: l2) {
			System.out.println(x);
		}
		
		System.out.println("l2 = ");
		l2.forEach(x -> System.out.println("@" + x));
		
		System.out.println("l2 = ");
		l2.forEach(System.out::println);
		
		System.out.println("s1 = ");
		openStream().forEach(System.out::println);
		
		System.out.println("s1 = ");
		openStream().forEach(s -> System.out.println("@" + s));

	}

	private static Stream<Integer> openStream() {
		return Stream.of(1, 5, -7, 3, 9);
	}

}

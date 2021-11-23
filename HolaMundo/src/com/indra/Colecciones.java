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
		l.add(5);
		l.add(7);
		l.add(-3);
		
		Stream<Integer> s1 = Stream.of(1, 5, -7, 3, 9);

	}

}

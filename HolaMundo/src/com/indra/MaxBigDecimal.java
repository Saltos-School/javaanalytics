package com.indra;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxBigDecimal {

	public static void main(String[] args) {
		Optional<BigDecimal> max = Stream.of("1.5", "20.3", "50.2789", "-5.0")
			.map(BigDecimal::new)
			.max(BigDecimal::compareTo);
		System.out.println("max: " + max);
		
		Stream<String> s = Stream.of("hola", "chao", "salut", "ciao", "hallo", "hello")
				.parallel()
				.sorted((s1, s2) -> s1.length() - s2.length());
		s.forEachOrdered(System.out::println);
		
		System.out.println(Stream.of(1, 2, 5, -3).anyMatch(i -> i < 0));
		System.out.println(Stream.of(1, 2, 5, -3).noneMatch(i -> i < 0));
		System.out.println(Stream.of(1, 2, 5, -3).allMatch(i -> i < 0));
		System.out.println(Stream.of(1, 2, 5, -3).collect(Collectors.toList()));
		System.out.println(Stream.of(1, 2, 5, -3).findFirst());
		System.out.println(Stream.of(1, 2, 5, -3).findAny());
		
		Stream<Integer> n = Stream.of(1, 5, -4, 8, 7);
		Stream<Integer> n2 = n.flatMap(i -> Stream.of(i, -i));
		n2.forEach(System.out::println);
		
		Stream<Integer> x = Stream.of(1, 5, -4, 8, 7).parallel().flatMap(i -> Arrays.asList(i, -i).parallelStream());
		x.forEach(System.out::println);
		
		Stream.of("hola", "chao", "salut", "ciao", "hallo", "hello")
			.sorted()
			.flatMap(c -> Stream.of(c.toLowerCase(), c.toUpperCase()))
			.forEach(System.out::println);
		
		Stream.of("hola", "chao", "salut", "ciao", "hallo", "hello")
			.flatMap(c -> Stream.of(c.toLowerCase(), c.toUpperCase()))
			.sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
			.forEach(System.out::println);
				
	}

}

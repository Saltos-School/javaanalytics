package com.indra;

import java.util.Optional;
import java.util.stream.Stream;

public class MapReduce {

	public static void main(String[] args) {
		System.out.println("Stream original");
		abrirStream().limit(5).forEach(System.out::println);
		
		System.out.println("Items * 10");
		abrirStream().limit(5).map(i -> i * 10).forEach(System.out::println);
		
		System.out.println("Items * 10 (mix)");
		abrirStream().limit(5).forEach(i -> System.out.println(i * 10));

		System.out.println("Items * 10 (parallel)");
		abrirStream().limit(5).parallel().map(i -> i * 10).forEachOrdered(System.out::println);
		
		System.out.println("Tamaño de cadenas");
		abrirStream2().map(s -> s.length()).forEach(System.out::println);
		
		System.out.println("Convertir a numeros y filtrar");
		abrirStream2()
			.parallel()
			.map(MapReduce::convertirAEntero)
			.filter(Optional::isPresent)
			.map(Optional::get)
			.filter(i -> i >= 0)
			.map(i -> i * 10)
			.forEach(System.out::println);
		
		System.out.println("Suma de 10 elementos");
		int suma = abrirStream().limit(10).reduce(0, (i, j) -> j + i);
		System.out.println(suma);
		
		System.out.println("Concatenar cadenas");
		String s = abrirStream2().reduce("", (acc, i) -> i + "." + acc);
		System.out.println(s);
		
		System.out.println("El numero más grande");
		int max = Stream.of(1, -2, 5, 7, 9).reduce(Integer.MIN_VALUE, (acc, i) -> i > acc ? i : acc);
		System.out.println(max);
				
		System.out.println("El numero más pequeño");
		int min = Stream.of(1, 11, 5, 7, 9).reduce(Integer.MAX_VALUE, (acc, i) -> i < acc ? i : acc);
		System.out.println(min);
		
		System.out.println("El numero más pequeño (optional)");
		Optional<Integer> min2 = abrirStream().skip(20).limit(10).reduce((acc, i) -> i < acc ? i : acc);
		min2.ifPresentOrElse(
				System.out::println,
				() -> System.out.println("No hay minimo porque no hay elementos"));
		
		System.out.println("La suma (reduce)");
		int suma2 = abrirStream().limit(20).reduce(0, (acc,  i) -> acc + i, (i, j) -> i + j);
		System.out.println(suma2);
		
		System.out.println("La suma (operaciones)");
		String suma3 = abrirStream()
				.limit(10)
				.parallel()
				.reduce(
						"0", 
						(acc, i) -> "(" + acc + " + " + i + ")", 
						(i, j) -> "[" + i + " ++ " + j + "]");
		System.out.println(suma3);
	}

	private static Stream<Integer> abrirStream() {
		return Stream.iterate(1, i -> i + 2);
	}
	
	private static Stream<String> abrirStream2() {
		return Stream.of("1", "-2", "5", "-7", "hola");
	}
	
	private static Optional<Integer> convertirAEntero(String s) {
		try {
			int i = Integer.valueOf(s);
			return Optional.ofNullable(i);
		} catch(NumberFormatException e) {
			return Optional.empty();
		}
	}
}

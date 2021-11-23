package com.indra;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class Flujos {

	public static void main(String[] args) {
		
		Stream<Integer> s1 = Stream.of(1, 2, 5, -7, 3);
		
		Stream<Integer> s2 = Stream.iterate(0, i -> i + 1);
		
		Consumer<Integer> consumer = i -> System.out.print(i + " ");
		
		System.out.println("s1:");
		s1.forEach(consumer);
		
		System.out.println();
		System.out.println("s2:");
		s2
			.skip(2)
			.limit(10)
			.forEach(Flujos::imprimir);
		
		Stream<Integer> s3 = Stream.iterate(0, i -> i < 20, i -> i + 2);
		System.out.println();
		System.out.println("s3:");
		s3
			.dropWhile(i -> i < 5)
			.takeWhile(i -> i < 16)
			.forEach(Flujos::imprimir);
		
		System.out.println();
		System.out.println("s4:");
		Stream<Double> s4 = Stream.generate(() -> Math.random() * 100);
		s4
			.limit(5)
			.forEach(Flujos::imprimir);
	}
	
	private static void imprimir(Object i) {
		System.out.print(i + " ");
	}

}

package com.indra;

import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MoreStreams {

	public static void main(String[] args) {
		int conteo = Stream.of("a", "b", "c")
			.parallel()
			.reduce(0,
					(acc, i) -> acc + 1,
					(i, j) -> i + j);
		System.out.println("Conteo: " + conteo);
		
		long conteo2 = Stream.of(1, 20, -5, 50).count();
		System.out.println("Conteo2: " + conteo2);
		
		IntStream s = Stream.of("1", "5", "-9").mapToInt(Integer::valueOf);
		IntSummaryStatistics resultados = s.summaryStatistics();
		System.out.println("La suma es: " + resultados.getSum());
		System.out.println("El promedio es: " + resultados.getAverage());
		
		Optional<MinMax> r = Stream.of(0, 5, 6, 7, -2).reduce(
				MinMax.empty(),
				MinMax::ganador,
				MinMax::ganador);
		
		System.out.println("Resultado: " + r);
	}

}

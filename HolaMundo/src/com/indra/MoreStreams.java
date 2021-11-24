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
				Optional.<MinMax>empty(),
				(acc, i) -> {
					if (acc.isEmpty()) {
						MinMax minMax = new MinMax();
						minMax.setMin(i);
						minMax.setMax(i);
						return Optional.ofNullable(minMax);
					} else {
						MinMax minMax = acc.get();
						int min = minMax.getMin();
						int max = minMax.getMax();
						MinMax nuevoMinMax = new MinMax();
						nuevoMinMax.setMax(i > max ? i : max);
						nuevoMinMax.setMin(i < min ? i : min);
						return Optional.ofNullable(nuevoMinMax);
					}
				},
				(i, j) -> {
					if (i.isEmpty()) {
						return j;
					}
					if (j.isEmpty()) {
						return i;
					}
					int minI = i.get().getMin();
					int maxI = i.get().getMax();
					int minJ = j.get().getMin();
					int maxJ = j.get().getMax();
					MinMax nuevoMinMax = new MinMax();
					nuevoMinMax.setMin(minI < minJ ? minI : minJ);
					nuevoMinMax.setMax(maxI > maxJ ? maxI : maxJ);
					return Optional.ofNullable(nuevoMinMax);
				});
		r.ifPresent(minMax -> System.out.println("min: " + minMax.getMin()));
		r.ifPresent(minMax -> System.out.println("max: " + minMax.getMax()));
	}

}

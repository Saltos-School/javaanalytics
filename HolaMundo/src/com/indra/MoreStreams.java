package com.indra;

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
	}

}

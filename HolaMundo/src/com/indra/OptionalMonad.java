package com.indra;

import java.util.Optional;
import java.util.function.Consumer;

public class OptionalMonad {

	public static void main(String[] args) {
		String s1 = "Paul";
		String s2 = null;
		
		Optional<String> o1 = Optional.ofNullable("Ana");
		Optional<String> o2 = Optional.empty();
				
		System.out.println("s1 size: " + getSize(s1));
		System.out.println("s2 size: " + getSize(s2));
		
		System.out.println("o1 size: " + getSize(o1));
		System.out.println("o2 size: " + getSize(o2));
		
		String c1 = o1.orElse(getEmptyString());
		String c2 = o2.orElse(getEmptyString());
		
		System.out.println("c1: " + c1);
		System.out.println("c2: " + c2);
		
		System.out.println("o1: " + o1);
		System.out.println("o2: " + o2);
		
		String c3 = o1.orElseGet(() -> getEmptyString());
		String c4 = o1.orElseGet(() -> getEmptyStringConError());

		System.out.println("c3: " + c3);
		System.out.println("c4: " + c4);
		
		// EJERCICIO sacar el consumer de c5 como un lambda
		Consumer<String> consumer5 = c5 -> System.out.println("c1: " + c5);
		
		// EJERCICIO sacar el consumer de c6 como un anonymous class
		Consumer<String> consumer6 = new Consumer<String>() {
			@Override
			public void accept(String c6) {
				System.out.println("c6: " + c6);
			}
		};
		
		o1.ifPresent(consumer5);
		o2.ifPresent(consumer6);
		
		o2.ifPresentOrElse(
				c7 -> System.out.println("c7: " + c7),
				() -> System.out.println("está vacío"));
		
		if (o2.isPresent()) {
			System.out.println("o2: " + o2.get());
		} else {
			System.out.println("está vacío");
		}
		
	}
	
	static int getSize(String s) {
		if (s == null) {
			return 0;
		}
		return s.length();
	}

	static int getSize(Optional<String> o) {
		if (o.isPresent()) {
			return o.get().length();
		}
		return 0;
	}
	
	static String getEmptyString() {
		return "";
	}
	
	static String getEmptyStringConError() {
		throw new RuntimeException("Ejemplo de error");
	}
	
}

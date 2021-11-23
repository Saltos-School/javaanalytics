package com.indra;

class Programa implements Runnable {

	@Override
	public void run() {
		System.out.println("Programa ejecutando en: " + Thread.currentThread().getName());
	}
	
}

public class Lambdas {

	public static void main(String[] args) {

		System.out.println("Ejecutando en el thread: " + Thread.currentThread().getName());
		
		Programa p1 = new Programa();
		p1.run();
		
		Thread t1 = new Thread(p1);
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {			
			@Override
			public void run() {
				System.out.println("Clase anonima en: " + Thread.currentThread().getName());
			}
		});
		t2.start();
		
		Thread t3 = new Thread(() -> System.out.println("Lambda en: " + Thread.currentThread().getName()));
		t3.start();
		
		Runnable p2 = () -> System.out.println("Lambda en: " + Thread.currentThread().getName());
		Thread t4 = new Thread(p2);
		t4.start();
	}

}

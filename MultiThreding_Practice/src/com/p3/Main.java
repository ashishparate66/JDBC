package com.p3;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Company comp = new Company();
		
		Producer p = new Producer(comp);
		Consumer c = new Consumer(comp);
		p.start();
		c.start();
		
	}
}

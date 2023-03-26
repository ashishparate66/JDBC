package com.multithreding;

class RunDemo1 implements Runnable {
	@Override
	public void run() {
		System.out.println("Start");
		System.out.println(Thread.currentThread().getName());
	   for(int i=0; i<50; i++) {
		   System.out.print("#");
	   }
	   System.out.println("Bye bye child" + Thread.currentThread().getName());
	}       
}

public class ThreadA{
	
	public static void main(String[] args) {
		
		Runnable r = new RunDemo1();
		Thread t1 = new Thread(r);
		t1.start();
		
		for(int i = 0; i < 50; i++) {
			System.out.print("&");
		}
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Bye Bye main " + Thread.currentThread().getName());
	}
}

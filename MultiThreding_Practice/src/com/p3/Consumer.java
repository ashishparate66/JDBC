package com.p3;

public class Consumer extends Thread {

	Company c;
	public Consumer(Company c) {
		this.c = c;
	}
	@Override
	public void run() {
		
		while(true) {
			
		   try {
			   this.c.consum_item();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		}
	}
}

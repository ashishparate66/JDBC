package com.p2;

public class Main2 extends Thread{
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			if(i%2==0) {
				System.out.println("this is even no: "+i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Main2 m = new Main2();
		m.start();
	}
}

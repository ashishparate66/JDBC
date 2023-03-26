package com.p1;

public class Main extends Thread {
  
	static boolean flag = true;
	
	@Override
	public void run() {
		synchronized (this) {
			
			try {
				if(flag) wait();
				for(int i=1; i<=20; i++) {
					if(i%2==0) {
						System.out.println(i+" ");
					}
					notify();
					wait();
				}	
			} catch (InterruptedException e) {
				
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Main();
		t1.start();
		synchronized (t1) {
				for(int i=1; i<=20; i++) {
					if(i%2==1) {
						System.out.println(i+" ");
					}
					flag=false;
					t1.notify();
					t1.wait();
				}	
				t1.notify();
		}
		System.out.println("bye");
	}
}

package com.p3;
class T1 extends Thread{
	@Override
	public void run() {
		synchronized (this) {
			for(int i=201; i<=300; i++) {
				int count=0;
				for(int j=1; j<=i; j++) {
					if(i%j==0) {
						count++;
					}
				}
				if(count==2) {
					System.out.println("Prime No "+i);
//					System.out.println("T1");
				}		
			}
		}
	}
}
class T2 extends Thread{
	@Override
	public void run() {
		for(int i=400; i>300; i--) {
			int count=0;
			for(int j=1; j<=i; j++) {
				if(i%j==0) {
					count++;
				}
			}
			if(count==2) {
				System.out.println("Prime No "+i);
			}
		}
	}
}
class T3 extends Thread{
	@Override
	public void run() {
		for(int i=601; i<=700; i++) {
			int count=0;
			for(int j=1; j<=i; j++) {
				if(i%j==0) {
					count++;
				}
			}
			if(count==2) {
				System.out.println("Prime No "+i);
			}
		}
	}
}
public class Main {
public static void main(String[] args) {
	T1 t1 = new T1();
	T2 t2 = new T2();
	t2.setPriority(7);
	T3 t3 = new T3();
	t3.setPriority(3);
	
	t1.start();
	try {
		t1.join();
		t2.start();
		t3.start();	
		t2.join();
		t3.join();	
	} catch (InterruptedException e1) {
		
		e1.printStackTrace();
	}
	
	
	System.out.println("bye bye main");
 }
}

package com.p1;
class Salman implements Runnable{
	@Override
	public void run() {
		int sum=0;
		for(int i=1; i<=10; i++) {
			sum+=i;
		}
		System.out.println(sum);
	}
}
class Hritik implements Runnable{
	@Override
	public void run() {
		int mul=1;
		for(int i=1; i<=10; i++) {
			mul*=i;
		}
		System.out.println(mul);	
	}	
}
public class Akshay {
	
	public static void main(String[] args) {
		Salman s = new Salman();
		Hritik h = new Hritik();
		Thread t1 = new Thread(s);
		Thread t2 = new Thread(h);
		t1.start();
		t2.start();
		Thread.currentThread().setName("Akshay");
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		for(int i=1; i<=10; i++) {
			System.out.print(Thread.currentThread().getName()+" ");
		}
		
	}
}

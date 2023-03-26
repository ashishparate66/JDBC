package com.p2;

public class Main{
	public static void main(String[] args) {
		
		Common c = new Common();
		
		Salman s = new Salman(c);
		Hrithik h = new Hrithik(c);
		
		s.start();
		h.start();
		
		try {
			s.join();
			h.join();
		} catch (InterruptedException e) {
			
		}
		System.out.println("Bye Bye Main");
	}
}


class Salman extends Thread{
	Common c;
	public Salman (Common c) {
		this.c=c;
	}
	
	@Override
	public void run() {
		c.evenNumber();
	}
}

class Hrithik extends Thread{
	Common c;
	public Hrithik (Common c) {
		this.c=c;
	}
	
	@Override
	public void run() {
		c.oddNumber ();
	}
}

class Common{
	
	boolean flag = true;
synchronized public void evenNumber() {
		
		for(int i=0; i<=20; i=i+2) {
			System.out.print(i+" ");
			flag=false;
			
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
    synchronized public void oddNumber() {
		if(flag)
			try {
				wait();
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
    	
		for(int i=1; i<20; i=i+2) {
			System.out.print(i+" ");
			
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		notify();
	}
}
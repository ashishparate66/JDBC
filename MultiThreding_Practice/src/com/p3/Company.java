package com.p3;

public class Company {
	
   int n;
   boolean f = true;
   synchronized	public void produce_item(int n) throws InterruptedException {
	   if(!f) {
		   wait();
	   }
		this.n=n;
		System.out.println("Produce : "+this.n);
		f=false;
		notify();
		
	}
	
   synchronized public int consum_item() throws InterruptedException {
		
	   if(f) {
		   wait();
	   }
    	System.out.println("Consume : "+this.n);
    
    	f=true;
    	notify();
    	return this.n;
	}
}

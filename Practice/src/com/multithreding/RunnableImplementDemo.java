package com.multithreding;
class RunDemo implements Runnable{//step-1
	@Override
	public void run() {//step-2
		//whatever you wanted to make the new thread do, write here
		System.out.println("New Thread is having name " + Thread.currentThread().getName());
		for(int i = 0; i < 100; i++) {
			System.out.print("$");
		}
		System.out.println("Bye Bye " + Thread.currentThread().getName());
	}
}

public class RunnableImplementDemo {
	public static void main(String[] args) {
		//Create object of class that implements Runnable interface
		Runnable r = new RunDemo();	//step-3
		Thread t1 = new Thread(r);	//step-4	New thread is created but it is not in execution so its state is NEW
		//System.out.println(t1.getState());	uncomment to see state of Thread
		//to put the new Thread in the execution, call the start() method using the Thread class
		t1.start();	//step-5	New thread is in execution its state is RUNNABLE
		//main thread will also continue its execution and the new thread will execute the body of run method
		for(int i = 0; i < 100; i++) {
			System.out.print("%");
		}

		//code to ensure that main thread should finish in last
		try{
			t1.join();	//execution of main thread will be suspended until the Thread-C completes its execution (died)
		}catch(InterruptedException ex) {
			System.out.println();
		}
		System.out.println("Bye Bye main");
	}
}



package com.p4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class A{
	public static void main(String ags[]) throws InterruptedException, ExecutionException{
		ExecutorService es = Executors.newFixedThreadPool(3);  // ----- (1)
		Runnable r = () -> {};
		Callable<String> c = () -> "B";
		
		for(int i = 0; i <= 8; i++){
			Future f = es.submit(r); // ----- (2)
			System.out.print(f.get() != null?"A":"");  // 9 Times A will be printed----- (3)
		}
		
		for(int i = 9; i <= 10; i++){
			Future<String> f = es.submit(c);
			String result = f.get();
			System.out.print(result != null?result:"C"); // 2 times c will be printed----- (4)
		}
		
		es.shutdown();  //----- (5)
	}
}
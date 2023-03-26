package com.p2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  
	public static void main(String[] args) {
		Runnable r1 = ThreadOperation::reverseArray;
		Runnable r2 = new ThreadOperation()::findNearestToAverage;
		
		RunThread rt =Thread::start;
		
		List<Thread> list = new ArrayList<>();
		list.add(new Thread(r1));
		list.add(new Thread(r2));
		
		rt.startThread(list.get(0));
		rt.startThread(list.get(1));
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.err.println("Bye bye main");
	}
	
	
}

class ThreadOperation{
	static void reverseArray() {
	 
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		
		for(int i=0; i<arr.length/2; i++) {
			int temp =arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
			System.out.println("Swapping "+ arr[i]+", "+arr[arr.length-1-i]);
		}
		for(int i:arr) System.out.println(i+" ");
	}
	
	
	void findNearestToAverage() {
	List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	
	double avg = list.stream().collect(Collectors.averagingDouble(i->i*1.0));
	
	int diff = Integer.MAX_VALUE;
	int near = list.get(0);
	
	for(int i:list) {
		if(Math.abs(i - avg) < diff) {
			diff = (int)Math.abs(i-avg);
			near=i;
		}	
	}
	System.out.println("Average is "+avg + " element nearest to average is "+near);
	}
}

@FunctionalInterface
interface RunThread{
	void startThread(Thread t);
}
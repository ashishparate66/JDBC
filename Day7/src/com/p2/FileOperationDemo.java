package com.p2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileOperationDemo {

	public static void main(String[] args) {
		
		String filename = "B.txt";
		
		String contentToWrite="Originally formed in 1600 purely to trade with the Mughal Empire, the Company needed to secure its commercial posts at Calcutta, Bombay and Madras. It purchased land from Indian rulers to build its settlements on, and recruited native armed forces to protect them. Eventually, these evolved into the Bengal, Bombay and Madras Armies.";
		
		String contentToAppend="After successfully battling the French for trading supremacy, and simultaneously involving itself in local politics, the Company became India’s leading power following Robert Clive’s victory at Plassey in 1757. In the years that followed, it expanded its Indian domains.";
	      
		ReadWriteCenter rwc = new ReadWriteCenter(filename, contentToWrite, contentToAppend);
		
		Runnable write = rwc::writeToFile;
		Runnable append = rwc::appendToFile;
		
		Callable<List<Integer>> called = rwc::getAnalysis;
		
		Thread t1 = new Thread(write);
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
		
		}
		
		Thread t2 = new Thread(append);
		t2.start();
		
		ExecutorService es = Executors.newFixedThreadPool(1);
		 
		Future<List<Integer>> res = es.submit(called);
		
		es.shutdown();
		
		try {
			System.out.println("No of digits in the file "+res.get().get(0));
			System.out.println("No of letters in the file "+res.get().get(1));
			System.out.println("No of specials chars in the file "+res.get().get(2));
		
		}  catch (ExecutionException | InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("done") ;
	}
}


class ReadWriteCenter{
	File file;
	String contentToWrite;
	String contentToAppend;
	
	public ReadWriteCenter(String filename, String contentToWrite, String contentToAppend) {
		
		file= new File(filename);
		this.contentToWrite = contentToWrite;
		this.contentToAppend = contentToAppend;
	}
	public void writeToFile() {
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		    bw.write(contentToWrite);
		    
		    bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void appendToFile() {
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		  bw.append(contentToAppend);
		  
		  bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<Integer> getAnalysis(){
		
		List<Integer> list = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
		   
			String str = br.readLine();
			str += br.readLine();
			
			br.close();
			
			char[] chars = str.toCharArray();
			
			int digits=0, letters=0, specials=0;
			for(char c : chars) {
				if(c>=48 && c<=57) digits++;
				else if(c>=65 && c<=90 || c>=97 && c<=122) letters++;
				else specials++;
			}
			list.add(digits);
			list.add(letters);
			list.add(specials);
			
		} catch (IOException e) {
			
		}
		return list; 
	}
}

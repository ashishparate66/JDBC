package com.p3;
class A{
	synchronized void fun(){  // ----- (1), (2)
		try {
			wait();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}

class B implements Runnable{
	A a = new A();
	
	public void run(){
		synchronized(a){   //---- (3)
		  a.fun();
		}
		
		//say wait method is called somwhere for this thread
		notify();	//---- (4)
	}
}


// 
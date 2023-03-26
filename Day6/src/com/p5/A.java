package com.p5;

public class A{
  public void sayHello(String name){
    System.out.println("Welcome : "+name);
    try{
      Thread.sleep(2000);
    }catch(Exception e){
      e.printStackTrace();
    }
    System.out.println(name);
  }
}
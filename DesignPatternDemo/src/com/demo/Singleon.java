package com.demo;

import java.awt.Insets;

//µ¥ÀýÄ£Ê½
public class Singleon {
	private static Singleon instance;
	private Singleon(){};
	public static Singleon getInstance(){
		if (instance==null) {
			instance=new Singleon();
		}
		return instance;
	}
}
 class Singleton {
    private static Singleton instance;
    private Singleton (){}

    public static Singleton getInstance() {
     if (instance == null) {
         instance = new Singleton();
     }
     return instance;
    }
}
class test{
	 private static test instance;
	 private test(){ 
	 }
	 public static test getInstance(){
		 if (instance==null) {
			return new test();
		}
		 return instance;
	 }
 }
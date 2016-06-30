package com.day2;

import java.io.File;

class MyException extends Exception{
	public MyException() {
		// TODO Auto-generated constructor stub
		super("cuowu");
	}
	public MyException(String msg){
		super(msg);
	}
}
 class Demo3 {
	public static void main(String[] args) {
		Demo3 demo3=new Demo3();
		try{
			demo3.f1(1000);
		}catch(MyException e){
			System.out.println(e.getMessage());
		}finally {
			System.out.println("why");
		}
	}
	public void f1(int n) throws MyException {
		if(n<100){
			throw new MyException("haha");
		}
		else{
			System.out.println("right");
		}
	}
}

package com.demo;

public class Demo1 {
	
	public static void main(String[] args) {
		Thread hello=new Thread(new Runnable(){
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("helllo");
			}
		});
		hello.start();
		
	}
}

package com.day2;

public class Test {
	public  Test(String name,int age){
		System.out.println(name+age);
	}
	public  Test(){
		System.out.println("haha");
	}
	public static void main(String[] args) {
		new Test();
		new Test("nam",10);
	}
}

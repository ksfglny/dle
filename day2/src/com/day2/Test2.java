package com.day2;

public class Test2 {
	String sex;
	int age;
	public void panduan(String sex){
		if (sex=="ÄÐ") {
			System.out.println("ÄÐ");
		}else{
			System.out.println("Å®");
		}
	}
	public static void main(String[] args) {
		Test2 test2=new Test2();
		test2.panduan("Å®");
		
}
}

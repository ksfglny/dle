package com.demo;
public class Person {
	String name;
	int age;
	int height;
	
	boolean sex;
	public void eat(){
		System.out.println("iameatting");
		
	}
	public Person(){
		
	}
	public Person(String haha){
		this.name=haha;
	}
	private void jisuan(){
	   int  result=height+age;
	   System.out.println(result);
	}
	public void work(){
		System.out.println(this.name+"iseating");
	}
	public static void main(String[] args) {
		Person p=new Person("jack");
		p.eat();
//		p.age=12;
//		p.height=143;
		//p.jisuan();
		p.work();
		//p.test("name");s
		
		//System.out.println(res);
		//System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
		
	}
	public void test(String name){
		System.out.println(name);
	}
	
	
}


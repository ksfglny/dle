package com.demo;

import org.omg.CORBA.PRIVATE_MEMBER;

public class TestAction {
	private String username;
	private String age;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String execute() throws Exception{
		if (getUsername().equals("tom")) {
			System.out.println(getUsername());
			return "success";
		}
		return "false";
	}
	public String denglu(){
		
		
		System.out.println("hello");
		return "success";
	}
}

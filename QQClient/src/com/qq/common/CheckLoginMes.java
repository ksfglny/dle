package com.qq.common;

public class CheckLoginMes extends Message {
	final String MESTYPE="checklogin";
	public CheckLoginMes(QQUser sender,String getter,String content) {
		this.content=content;
		this.sender=sender.getUsername();
		this.getter=getter;
		this.time=getTime();
	}
}

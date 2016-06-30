package com.qq.common;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable{
	public String sender;
	public String getter;
	public String time;
	public String content="";

	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getGetter() {
		return getter;
	}
	public void setGetter(String getter) {
		this.getter = getter;
	}
	public String getTime() {
		return new Date().toLocaleString();
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String con) {
		this.content = con;
	}
	
	
}

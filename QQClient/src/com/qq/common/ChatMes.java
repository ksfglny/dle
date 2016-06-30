package com.qq.common;

public class ChatMes extends Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final String MES_TYPE="chat";
	public ChatMes(String sender,String getter,String content) {
		// TODO Auto-generated constructor stub
		this.sender=sender;
		this.content=content;
		this.getter=getter;
		this.time=getTime();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return sender+" "+time+" "+"\n"+content;
	}
}

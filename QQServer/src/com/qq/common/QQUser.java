package com.qq.common;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import com.server.*;
import com.server.tools.QQClientManger;
import com.qq.common.*;

public class QQUser {
	private String password;
	private String username;
	public Socket socket = null;
	public ObjectOutputStream oos = null;
	public ObjectInputStream ois = null;
	boolean connected = false;
	public ArrayList<String> onlineUser;
	public final String friendList="friendList.txt";
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public QQUser(String username,String password) {
		this.username=username;
		this.password=password;
		try {
			this.socket = new Socket("192.168.10.137", 10086);
			this.onlineUser=new ArrayList<String >();
			this.connected = true;
			this.oos = new ObjectOutputStream(socket.getOutputStream());
			this.ois = new ObjectInputStream(socket.getInputStream());
			if (checkLogin()) {
				//启动接听线程
				new Thread(new QQClientManger(this)).start();
				
			}
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	public boolean checkLogin(){
		sendMes(new CheckLoginMes(this,this.username,this.username+","+this.password));
		Object res=receiveMes();
System.out.println("checkLogin QQ");
		if (res instanceof CheckLoginMes ) {
			return false;
		}else {
			String ulMes=((QQonLineUserList)res).content;
			System.out.println(ulMes+" "+"ulmes");
			String []userList=ulMes.split(",");
			
			for(String username:userList){
				onlineUser.add(username);
				System.out.println("username:"+username);
			}
			return true;
		}
	}
	public Object receiveMes(){
			try {
				return ois.readObject();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		
	}
	
	public void sendMes(Message mes){
		try {
			oos.writeObject(mes);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	public boolean regis(){
		return false;
	}
	
}

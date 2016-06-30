package com.day3;

import java.io.*;
import java.net.*;

public class TCP {
	private BufferedReader reader;
	private ServerSocket server;
	private Socket socket;
	void getServer(){
		try {
			server=new ServerSocket(8998);
			System.out.println("socket has bulit");
			while(true){
				System.out.println("wait");
				server.accept();
				reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getClientMessage();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private void getClientMessage(){
		try {
			while(true){
				System.out.println(reader.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		try{
			if(reader!=null){
				reader.close();
			}
			if(socket!=null){
				socket.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		TCP tcp=new TCP();
		tcp.getServer();
	}
}

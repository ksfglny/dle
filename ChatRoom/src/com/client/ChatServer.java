package com.client;

import java.io.*;
import java.net.*;

import java.util.Date;

import java.util.*;

public class ChatServer {
	boolean connected = false;
	ServerSocket ss = null;
	List<Client> cList = new LinkedList<Client>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ChatServer().start();

	}

	class Client implements Runnable {
		Socket socket = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;

		public Client(Socket socket) {
			// TODO Auto-generated constructor stub
			this.socket = socket;
			try {
				this.ois = new ObjectInputStream(socket.getInputStream());
				this.oos = new ObjectOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void send(Message mes){
			try {
				oos.writeObject(mes);
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
		public void run() {
			boolean readable = false;
			try {
				for(int i=0;i<cList.size();i++){
					cList.get(i).send(new Message(socket.getLocalAddress().getHostName()+"connected"));
				}
				readable = true;

				while (readable) {
					Message mes = (Message) ois.readObject();
					for(int i=0;i<cList.size();i++){
						cList.get(i).send(mes);
					}
					//System.out.println(mes.toString());

				}
			} catch (Exception e) {
				try {
					ois.close();
					oos.close();
					cList.remove(this);
					socket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
				}
			}

		}
	}

	public void start() {
		try {
			ss = new ServerSocket(10084);
			connected = true;
			while (connected) {
				Socket sclient = ss.accept();
				Client client = new Client(sclient);
				cList.add(client);
				new Thread(client).start();
			}
		} catch (IOException e) {
			try {
				ss.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}


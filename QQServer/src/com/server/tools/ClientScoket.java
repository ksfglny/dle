package com.server.tools;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientScoket{
	private Socket s;
	public Socket getS() {
		return s;
	}
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	public ClientScoket(Socket socket) {
		// TODO Auto-generated constructor stub
		this.s = socket;
		try {
			this.oos = new ObjectOutputStream(s.getOutputStream());
			this.ois = new ObjectInputStream(s.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

package com.server.tools;

import java.io.*;
import java.net.*;
import java.util.*;
import com.qq.common.*;

public class ServerManger{
	ServerSocket ss;
	public static HashMap<String, ClientScoket> onlineUser = new HashMap<String, ClientScoket>();

	// ObjectOutputStream oos = null;
	// ObjectInputStream ois = null;
	public void start() {
		try {
			ss = new ServerSocket(10086);
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (true) {
			try {
				Socket s = ss.accept();
				new Thread(new ClientT(new ClientScoket(s))).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	
}
class ClientT implements Runnable {
	private String username;
	public ClientScoket s;
	public ClientScoket getS() {
		return s;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void run() {
System.out.println("run");
		while (true) {
			ClientScoket getterSocket = null;
			try {
				Object mes = s.ois.readObject();
				if (mes instanceof CheckLoginMes) {
System.out.println("checking");
					checkLogin((CheckLoginMes) mes);
System.out.println("checked");
				} else if (mes instanceof ChatMes) {
					
					ChatMes cMes = (ChatMes) mes;
					//System.out.println(cMes.content);
					getterSocket = ServerManger.onlineUser.get(cMes.getter);
//					oosGetter = new ObjectOutputStream(getterSocket.getOutputStream());
//					// ObjectInputStream oisGetter = null;
//					oosGetter.writeObject(mes);
					System.out.println("消息已经发送"+cMes.sender+"to"+cMes.getter+" "+cMes.content);
					getterSocket.oos.writeObject(cMes);
					
				}

			} catch (Exception e) {
				//try {
					//oosGetter.close();
					//getterSocket.close();
				
				ServerManger.onlineUser.remove(username);
				
				//} catch (IOException e1) {
					e.printStackTrace();
					break;
				//}

			}
		}
	}

	public ClientT(ClientScoket s) {
		// System.out.println("client built");
		this.s=s;
	}

	public boolean checkLogin(CheckLoginMes mes) {
		String info = mes.content;
System.out.println(info);
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("userinfo.txt")));
			String line = "";
			while ((line = br.readLine()) != null) {
				// System.out.println("server"+line);
				if (line.equals(info)) {
					// System.out.println(line);
					username = mes.sender;
					ServerManger.onlineUser.put(username, s);
					//QQonLineUserList userListMes = ;
					//userListMes.onlineUser = ;
					 //oos.writeObject(mes);
					s.oos.writeObject(new QQonLineUserList(ServerManger.onlineUser));
					return true;
				}
			}
			s.oos.writeObject(mes);
			return false;

		} catch (Exception e) {
			//try {
			ServerManger.onlineUser.remove(username);
		
//				s.close();
//				oos.close();
//				ois.close();
				//return false;
			//} catch (IOException e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			
			
		}
	}
}

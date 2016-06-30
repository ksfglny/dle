package com.qq.client.tools;

import java.io.IOException;
import com.qq.client.view.QQClient;
import com.qq.common.ChatMes;
import com.qq.common.CheckLoginMes;
import com.qq.common.QQUser;

//此类用来接收消息，当用户登陆成功后，线程开启。
public class QQClientManger implements Runnable {
	public QQUser user;
	
	public QQClientManger(QQUser user) {
		// TODO Auto-generated constructor stub
		this.user = user;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Object mes=receiveMes();
				if ( mes instanceof ChatMes) {
					ChatMes mescov =(ChatMes)mes;	
					 displayMes(mescov);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
			 
		}
	}
	public void displayMes(ChatMes mes){
		 QQClient.jta.setText(QQClient.jta.getText()+mes.toString()+"\n");
		 
	}
	public Object receiveMes() throws Exception {
		try {
			return user.ois.readObject();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
	

}

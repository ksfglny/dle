package com.qq.client.view;

import javax.swing.*;

import com.qq.common.ChatMes;
import com.qq.common.QQUser;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class QQClient extends JFrame implements ActionListener {
	JTextField jtf;
	public static JTextArea jta;
	JPanel jp;
	JButton jb1;
	JButton jb2;
	QQUser sender;
	String getter;
	JScrollPane jsp;
	public static void main(String[] args) {
		new QQClient(null, "2");
	}

	public QQClient(QQUser user, String target) {
		sender=user;
		getter = target;
		
		jtf = new JTextField(20);
		jtf.addActionListener(this);
		jtf.setActionCommand("enter");
		jta = new JTextArea();
		jsp=new JScrollPane(jta);
		jp = new JPanel();
		jb1 = new JButton("send");
		jb1.addActionListener(this);
		jb1.setActionCommand("send");
		jb2 = new JButton("sendAll");
		jb2.addActionListener(this);
		jb2.setActionCommand("sendall");
		jp.add(jtf);
		jp.add(jb1);
		jp.add(jb2);
		this.add(jsp, "Center");
		this.add(jp, "South");
		// pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setLocation(300, 300);
		setTitle(user.getUsername() + "正在和" + target + "聊天");
		setVisible(true);
		
	}

		
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("enter")||e.getActionCommand().equals("send")) {
			String content=jtf.getText().trim();
			jtf.setText("");
			System.out.println("client发送的消息"+content);
			ChatMes cMes=new ChatMes(sender.getUsername(), getter, content);
			System.out.println(cMes.sender+"to"+cMes.toString());
			sender.sendMes(cMes);
		}
	}

}

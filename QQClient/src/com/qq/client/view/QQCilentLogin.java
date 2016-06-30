package com.qq.client.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.qq.client.tools.QQClientManger;
import com.qq.common.QQUser;

public class QQCilentLogin extends JFrame implements ActionListener{
	//north
	JLabel jb1;
	//mid
	JPanel jp1;
	JTextField jtf1;
	JTextField jtf2;
	JLabel jb2;
	JLabel jb3;
	JLabel jb4;
	//south
	JPanel jp2;
	JButton jButton;
	JButton jButton2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   QQCilentLogin ql=new QQCilentLogin();

	}
	public QQCilentLogin() {
		//north
		jb1=new JLabel(new ImageIcon("image/tou.png"));
		//mid
		jp1=new JPanel(new GridLayout(2, 2));
		jtf1=new JTextField();
		jtf2=new JTextField();
		jb3=new JLabel("username",JLabel.CENTER);
		jb4=new JLabel("password",JLabel.CENTER);
		//jb2=new JLabel(new ImageIcon("image/touxiang.png"));
		//jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jtf1);
		//jp1.add(new JLabel(""));
		jp1.add(jb4);
		jp1.add(jtf2);
		
		//south
		jp2=new JPanel();
		jButton=new JButton("login");
		jButton.addActionListener(this);
		jButton.setActionCommand("login");
		jButton2=new JButton("regis");
		jButton2.addActionListener(this);
		jButton2.setActionCommand("regis");
		jp2.add(jButton);
		jp2.add(jButton2);
		//
		add(jb1,"North");
		add(jp1,"Center");
		add(jp2,"South");
		setTitle("myqq");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200, 200);
		setSize(430,330);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("login")) {
			///user.checklogin
			QQUser user=new QQUser(jtf1.getText().trim(), jtf2.getText().trim());
			if (user.checkLogin()) {
				this.dispose();
				QQFriendList qfl=new QQFriendList(user);
				new Thread(new QQClientManger(user)).start();
			}else{
				JOptionPane.showMessageDialog(this, "用户名或者密码错误！");
			}  
		}
		if (e.getActionCommand().equals("regis")) {
			//user.regis
		}
	}

}
////关闭登陆
//joptionpane.showmessagedialog(this,"error")
//jlabel.setEnable(false)
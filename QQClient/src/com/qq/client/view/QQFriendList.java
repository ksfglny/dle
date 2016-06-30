package com.qq.client.view;

import javax.swing.*;

import com.qq.common.QQUser;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//myfriendlist 
public class QQFriendList extends JFrame implements ActionListener,MouseListener{
	//display 
	JPanel jp1;
	JButton jb1;
	JScrollPane jSPane;
	JPanel jp2;
	QQUser owner;
	public  QQFriendList(QQUser user) {
		//north
		this.owner=user;
		jp1=new JPanel(new BorderLayout());
		jb1=new JButton("my friend");
		jp1.add(jb1,"North");
		//mid
		jp2=new JPanel(new GridLayout(20,1,4,4));
		getUserList(user);
		jSPane=new JScrollPane(jp2);
		//
		jp1.add(jSPane,"Center");
		add(jp1);
		setTitle("friendList");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		setSize(200, 500);
		setLocation(200, 200);
		setVisible(true);
		
	}
	public void getUserList(QQUser user){
		int lines=0;
		try {
			BufferedReader br=new BufferedReader(new FileReader(new File(user.friendList)));
			while(br.readLine()!=null){
				lines++;
			}
			br.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		try {
System.out.println("to getuserlist");
			BufferedReader br=new BufferedReader(new FileReader(new File(user.friendList)));
			String line="";
			while((line=br.readLine())!=null){
				String name=line.substring(0,line.indexOf(","));
				String image=line.substring(line.indexOf(",")+1);
				JLabel jl=new JLabel(name,new ImageIcon(image),JLabel.LEFT);
				jl.addMouseListener(this);
				jl.setEnabled(false);
				if (user.onlineUser.contains(name)) {
					jl.setEnabled(true);
				}
				jp2.add(jl);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// xdedao bianhao
		if (e.getClickCount()==2) {
			String target=((JLabel)e.getSource()).getText();
			new QQClient(owner,target);
		}	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		//e.getSource();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

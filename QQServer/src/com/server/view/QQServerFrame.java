package com.server.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.server.tools.ServerManger;
public class QQServerFrame extends JFrame implements ActionListener{
	JPanel jp;
	JPanel jptop;
	JPanel jpbody;
	JPanel jpfoot;
	JLabel jlleft;
	JLabel jlright;
	JButton jbleft;
	JButton jbright;
	JTextArea jtaleft;
	JTextArea jtaright;
	public QQServerFrame() {
		// TODO Auto-generated constructor stub
		jp=new JPanel();
		jptop=new JPanel(new GridLayout(1, 2));
		jpbody=new JPanel(new GridLayout(1, 2));
		jpfoot=new JPanel(new GridLayout(1, 2));
		jlleft=new JLabel("在线用户",JLabel.CENTER);
		jlright=new JLabel("消息列表",JLabel.CENTER);
		jbleft=new JButton("start");
		jbright=new JButton("stop");
		jtaleft=new JTextArea(20,16);
		jtaright=new JTextArea(20,16);
		jptop.add(jlleft);
		jpbody.add(jtaleft);
		jpfoot.add(jbleft);
		jptop.add(jlright);
		jpbody.add(jtaright);
		jpfoot.add(jbright);
		jbright.addActionListener(this);
		jbright.setActionCommand("stop");
		jbleft.addActionListener(this);
		jbleft.setActionCommand("start");
		jp.add(jptop,"North");
		jp.add(jpbody,"Center");
		jp.add(jpfoot,"South");
		this.add(jp);
		setTitle("QQserver");
		setSize(400,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(400, 400);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		QQServerFrame qqsf=new QQServerFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("start")) {
			ServerManger sm=new ServerManger();
System.out.println("starting");
			sm.start();
System.out.println("ok");
		}
		if (e.getActionCommand().equals("stop")) {
		}
	}
}

package com.day3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class Client extends JFrame {
	private PrintWriter writer;
	Socket socket;
	private JTextArea ta=new JTextArea();
	private JTextField tf=new JTextField();
	Container cc;
	public Client(String title){
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cc=this.getContentPane();
		final JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane,BorderLayout.CENTER);
		scrollPane.setViewportView(ta);
		cc.add(tf,"South");
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				writer.println(tf.getText());
				//System.out.println(tf.getText());
				ta.append(tf.getText()+'\n');
				ta.setSelectionEnd(tf.getText().length());
				tf.setText("");
			}
		});
		
	}
	private void connect(){
		ta.append("connect try");
		try{
			socket=new Socket("127.0.0.1",8998);
			
			writer=new PrintWriter(socket.getOutputStream(),true);
			ta.append("success");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
	Client client=new Client("test");
	client.setSize(200,300);
	client.setVisible(true);
	client.connect();
	}
}

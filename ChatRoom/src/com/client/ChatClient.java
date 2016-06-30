package com.client;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Date;

public class ChatClient extends Frame {
	Socket socket = null;
	TextField tField = new TextField();
	TextArea tArea = new TextArea();
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	boolean connected = false;

	class ReadMes implements Runnable {
		public void run() {
			try {
				while (connected) {
					Message mes = (Message) ois.readObject();
					tArea.setText(tArea.getText() + mes.toString());
				}

			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				//e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatClient().luanchFrame();
	}

	public void luanchFrame() {
		setLocation(400, 400);
		setSize(400, 500);
		add(tField, BorderLayout.SOUTH);
		add(tArea, BorderLayout.NORTH);
		pack();
		tField.addActionListener(new TfListener());
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				disconnect();
				System.exit(0);
			}

		});
		setVisible(true);
		connect();
		// System.out.println(1);
	}

	public void connect() {
		try {
			socket = new Socket("192.168.10.238", 10084);
			connected = true;
			tArea.setText("connected\n");
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			new Thread(new ReadMes()).start();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private class TfListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String s = tField.getText().trim();
			//tArea.setText(s);
			tField.setText("");
			try {
				//tArea.setText(mes.toString());
				oos.writeObject(new Message(s));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void disconnect() {
		try {
			oos.close();
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String hostName = "";
	String ip = "";
	String data = "";
	String time = "";

	Message(String data) {
		// TODO Auto-generated constructor stub
		try {
			this.ip = InetAddress.getLocalHost().getHostAddress();
			this.hostName = InetAddress.getLocalHost().getHostName();

		} catch (UnknownHostException e) {

			e.printStackTrace();
		}
		this.data = data;
		this.time = new Date().toLocaleString();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return hostName + " " + ip + " " + time + " " + data+"\n";
	}
}

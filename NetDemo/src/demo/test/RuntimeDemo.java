package demo.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class RuntimeDemo {
	public static void main(String[] args) throws Exception{
		Runtime runtime=Runtime.getRuntime();
		
		Process process=runtime.exec("notepad.exe");
		Thread.sleep(2000);
		process.destroy();
		Thread t1=new Thread(new TcpClient3());
		Thread t2=new Thread(new TcpServer3());
		
		t2.start();
		t1.start();
	}
}
class UdpSend3 implements Runnable{
	public void run(){
		try {
			DatagramSocket dSocket=new DatagramSocket();
			byte[] buf="hello".getBytes();
			DatagramPacket dPacket=new DatagramPacket(buf, buf.length,InetAddress.getByName("192.168.10.52"),1008);
			dSocket.send(dPacket);
			dSocket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
class UdpReceive3 implements Runnable{
	public void run(){
		try {
			DatagramSocket ds=new DatagramSocket(1008);
			byte buf[]= new byte[10];
			DatagramPacket dp=new DatagramPacket(buf,buf.length);
			ds.receive(dp);
			System.out.println(new String(dp.getData(),0,dp.getLength()));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
class TcpClient3 implements Runnable{
	public void run(){
		try {
			Socket sc=new Socket("192.168.10.52", 10086);
			OutputStream out=sc.getOutputStream();
			out.write("helloworld".getBytes());
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
class TcpServer3 implements Runnable{
	public void run(){
		try {
			ServerSocket serverSocket=new ServerSocket(10086);
			Socket sClient=serverSocket.accept();
			byte[] buff=new byte[1024];
			InputStream in=sClient.getInputStream();
			int len=in.read(buff);
			System.out.println(new String(buff,0,len));
			sClient.close();
			serverSocket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
package demo.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpDemo1 {
	public static void main(String[] args) {
		Thread t1=new Thread(new TcpClient());
		Thread t2=new Thread(new TcpServer());
		t2.start();
		t1.start();
	}

}

class TcpClient implements Runnable{
	public void run(){
		try {
			Socket sclient=new Socket("192.168.10.52",10002);
			OutputStream outputStream=sclient.getOutputStream();
			BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
			String line=null;
			InputStream inputStream=sclient.getInputStream();
			
			while((line=bReader.readLine())!=null){
				
				outputStream.write(line.getBytes());
				byte[] inbuf=new byte[1024];
				int len=inputStream.read(inbuf);
				System.out.println(new String(inbuf,0,len));
			}
				
			
			sclient.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
class TcpServer implements Runnable{
	
	public void run(){
		try {
			ServerSocket serverSocket =new ServerSocket(10002);
			Socket sClient=serverSocket.accept();
			String ip=sClient.getInetAddress().getHostAddress();
			System.out.println(ip);
			String line=null;
			byte[] buf=new byte[1024];
			InputStream inputStream = sClient.getInputStream();
			int len=0;
			while((len=inputStream.read(buf))!=-1){
				line=new String(buf,0,len);
				if (line.equals("over")) {
					break;
				}
				
				OutputStream outputStream=sClient.getOutputStream();
				byte[] outbuf=line.toUpperCase().getBytes();
				outputStream.write(outbuf);
			}
			serverSocket.close();
			sClient.close();
			
		
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			
		}
		
	}
}
package demo.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class Demo4 {
	public static void main(String[] args) {
		UdpSend uSend=new UdpSend();
		UdpReceive uReceive=new UdpReceive();
		Thread t1=new Thread(uSend);
		Thread t2=new Thread(uReceive);
		t1.start();
		t2.start();
	}
}
class UdpReceive implements Runnable{
	public  void run() {
		
		try {
			DatagramSocket dSocket=new DatagramSocket(10000);
			while(true){
				byte[] buf=new byte[1024];
				DatagramPacket dPacket=new DatagramPacket(buf, buf.length);
				dSocket.receive(dPacket);
				System.out.println(new String(dPacket.getData(),0,dPacket.getLength()));
				
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
 class UdpSend implements Runnable{
	 public  void run(){
	 	try {
	 		DatagramSocket dSocket=new DatagramSocket();
	 		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
	 		String  line=null;
	 		while(((line=bufferedReader.readLine())!=null)){
	 			byte[] buf=line.getBytes();
	 			DatagramPacket dPacket=new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.10.52"),10000);
	 			dSocket.send(dPacket);
	 		}
	 	} catch (Exception e) {
	 		// TODO: handle exception
	 	}
	 	
	 }
	 }
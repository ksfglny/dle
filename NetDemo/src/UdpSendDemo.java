import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.Buffer;

public class UdpSendDemo implements Runnable{
public  void run(){
	try {
		DatagramSocket dSocket=new DatagramSocket();
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		String  line=null;
		while(((line=bufferedReader.readLine())!=null)){
			byte[] buf=line.getBytes();
			DatagramPacket dPacket=new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.10.52"),10004);
			dSocket.send(dPacket);
		}
	} catch (Exception e) {
		// TODO: handle exception
	}finally {
		//dSocket.close();
	}
	
}
}

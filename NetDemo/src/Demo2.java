import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class Demo2 {
	public static void main(String[] args) throws Exception{
		UdpSend uSend=new UdpSend();
		UpdReceive uReceive=new UpdReceive();
		Thread t1=new Thread(uSend);
		Thread t2=new Thread(uReceive);
		t1.start();
		t2.start();
	}
}
class UdpSend implements Runnable{
	public void run(){
		try {
			DatagramSocket dSocket=new DatagramSocket();
			byte [] buf = "i love you ".getBytes();
			DatagramPacket packet=new DatagramPacket(buf, buf.length,InetAddress.getByName("192.168.10.52"),10000);
			dSocket.send(packet);
			dSocket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
class UpdReceive implements Runnable{
	public void run(){
			try {
				DatagramSocket dSocket=new DatagramSocket(10000);
				byte [] buf = new byte[1024];
				DatagramPacket dPacket=new DatagramPacket(buf, buf.length);
				dSocket.receive(dPacket);
				String data=new String(dPacket.getData(),0,dPacket.getLength());
				System.out.println(data);
				dSocket.close();
			} catch (Exception e) {
				// TODO: handle exception
				
			}
		}
}
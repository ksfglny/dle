import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo1 {
	public static void main(String[] args) {
		InetAddress ipAddress[] = null;
		try {
			ipAddress = InetAddress.getAllByName("baidu.com");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(InetAddress x:ipAddress){
			System.out.println(x.getHostAddress());
		}
		 
	}
}

package day621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
public static void main(String[] args) throws UnknownHostException, IOException {
	Socket sc =new Socket("192.168.10.137",10086);
	 InputStream in =sc.getInputStream();
			InputStreamReader ir=new InputStreamReader(in);
		BufferedReader br=new BufferedReader(ir);
		String content =br.readLine();
		System.out.println(content);
			ir.close();
			br.close();
			in.close();
			sc.close();

}

}

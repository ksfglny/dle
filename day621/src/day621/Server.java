package day621;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
public static void main(String[] args) throws IOException {
	ServerSocket ss=new ServerSocket(10086);
	while(true){
		Socket s=ss.accept();
		System.out.println("���Ե��������");
		OutputStream out=s.getOutputStream();
		PrintStream pr=new PrintStream(out);
		pr.print("�������Ϸ�����");
		pr.close();
		out.close();
}

}
}

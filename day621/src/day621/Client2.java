package day621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {
public static void main(String[] args) throws UnknownHostException, IOException {
Socket s=new Socket("192.168.10.137",10086);
InputStream in=s.getInputStream();
InputStreamReader ir=new InputStreamReader(in);
BufferedReader br=new BufferedReader(ir);
String ss=br.readLine();
System.out.println(ss);	
}
}

package Demo.com;

import java.util.Arrays;

public class Demo1 {
	//²éÕÒ
	public static void main(String[] args) {
		String s1="abffedd";
		String s6="1230";
		
		sop(Integer.parseInt(s6));
		sop(reverse(s1));
		StringBuffer sBuffer=new StringBuffer(s1);
		sBuffer.append(s1);
		sBuffer.append(true);
		sop(sBuffer.toString());
		sop(s1.charAt(3));
		sop(s1.indexOf("f",4));
		sop(s1.contains("ff"));
		sop(s1.startsWith("a"));
		sop(s1.endsWith("d"));
		char[] ch1={'a','x','c','f'};
		sop(String.copyValueOf(ch1));
		sop(String.valueOf(ch1));
		sop(s1.toCharArray());
		String s2=new String(ch1);
		sop(s2);
		String s3=s1.replace("a", "double");
		sop(s3);
		String[] s4=s1.split("f");
		sop(s4.length);
		sop(s4.toString());
		String s5=" as as as    ";
		sop(s5.trim().replace(" ", ""));
		
	}
	public static void sop(Object object){
		System.out.println(object);
	}
	public static  String reverse(String s){
		char[] res=new char[s.length()];
		for(int i=s.length();i>0;i--){
			res[s.length()-i]=s.charAt(i-1);
		}
		return String.valueOf(res);
	}
	//
}

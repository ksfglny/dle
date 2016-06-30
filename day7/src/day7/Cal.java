package day7;
import java.util.*;
public class Cal {
	int jisuan(int a,String oper,int b){
		
		switch (oper) {
		case "+":
			return a+b;
		case "-":
			return a-b;
		case "*":
			return a*b;
		case "/":
			if(b==0){
				System.out.println("false");
			}else{
				return a/b;
			}
		default:
			return 0;
			
		}
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);

		while (true){
			//System.out.println("please input Êý×Ö1");	
		if (scanner.nextLine().equals("exit")) {
			break;
		}	
		System.out.println("please input Êý×Ö1");
		String  num1=scanner.nextLine();
		System.out.println("please input ·ûºÅ");
		String oper=scanner.nextLine();
		System.out.println("please input Êý×Ö2");
		String num2=scanner.nextLine();
		Cal cal=new Cal();
		int res=cal.jisuan(Integer.valueOf(num1), oper,Integer.valueOf(num2));		
		System.out.println(res);
		}
	}

}

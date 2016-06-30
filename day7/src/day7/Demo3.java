package day7;
//import java.io.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Demo3 {
	public static void main(String[] args) {
		File file=new File("D:\\bb.txt");
		try{
			InputStream inputStream=new FileInputStream(file);
			Scanner sc=new Scanner(inputStream);
			int code=0;
			int quto=0;
			while(sc.hasNextLine()){
				String line=sc.nextLine();
				System.out.println(line);
				if (line.contains("//")) {
					quto+=1;
				}else{
					code+=1;
				}
			}
			System.out.println("´úÂë"+code);
			int i=Integer.parseInt(String.valueOf(3));
			//String.valueOf(3)
			//i=5;
			System.out.println(i);
			System.out.println("×¢ÊÍ"+quto);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

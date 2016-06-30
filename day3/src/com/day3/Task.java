package com.day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Task {
	public static void main(String[] args) {
		int[] fs={60,70,80,90,100};
		
		for(int i=0;i<fs.length;i++){
			if(fs[i]<60){
				System.out.println("bujige");
			}else if(fs[i]>=60&&fs[i]<70){
				System.out.println("jige");
			}else if(fs[i]>=70&&fs[i]<80){
				System.out.println("liang");
			}else if(fs[i]>=80&&fs[i]<90){
				System.out.println("you");
			}else{
				System.out.println("youxiu");
			}
		}
		File file=new File("aa.txt");
		try {
			FileInputStream fileInputStream=new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

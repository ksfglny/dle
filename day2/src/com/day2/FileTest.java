package com.day2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/**this is a */
public class FileTest {
	
	public static void main(String[] args) {
		int i=1;
		System.out.println(i);
		File file=new File("word.txt");
		int a[][]={{1,3},{2,4}};
		FileTest fileTest=new FileTest();
		fileTest.each(a);
		/**this is a */
		System.out.println(a.length);
		if(file.exists()){
			file.delete();
			System.out.println("文件删除");
			
		}else{
			try{
				file.createNewFile();
				
				System.out.println("文件已经创建");
				FileOutputStream outputStream=new FileOutputStream(file);
				byte buy[]="我有一只小小小毛驴".getBytes();
				outputStream.write(buy);
				outputStream.close();
				FileInputStream inputStream=new FileInputStream(file);
				byte[] byt=new byte[1024];
				int len=inputStream.read(byt);
				System.out.println(new String(byt,0,len));
				System.out.println(len);
				System.out.flush();
				System.out.write(byt);
				inputStream.close();
			}catch(Exception e){
				e.printStackTrace();
				}
		}
	}
	/**this is x x a */
	public void each(int a[][]){
		for(int x[]:a){
			for(int k:x){
				System.out.println(k);
			}
		}
	}


}

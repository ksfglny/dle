package day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Test2 {
	public static void main(String[] args) throws Exception{
		File file=new File("E:\\ff.txt");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String c="";
		String line="";
	     while((line=br.readLine())!=null){
	    	 c=c+line;
	     }
	     	System.out.println(c);
	     	fr.close();
	     	br.close();
	     	
	     	String []res=c.split(" ");

	   			int [] count=new int[res.length];
	   			for(int k=0;k<res.length;k++){
	   				if(res[k].equals("")){
	   					count[k]=0;
	   					continue;
	   				}
	   				count[k]=1;
	   				for(int j=k+1;j<res.length;j++){
	   					if(res[k].equals(res[j])){
	   						res[j]="";
	   						count[k]++;
	   					}
	   				
	   				}
	   			
	   			}
	   			String out[]=new String[count.length];
	   			for(int i=0;i<count.length;i++){
	   	
	   				out[i]=res[i]+count[i];
	   				if(!(out[i].contains("0"))){
	   					System.out.println(out[i]);
	   				}
	   			}
	   			
	   			
		}
}




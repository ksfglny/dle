import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BuffDemo {
	public static void main(String[] args) throws Exception {
		BufferedWriter bfWriter=new BufferedWriter(new FileWriter("hah.txt"));
		for(int i=0;i<6;i++){
			bfWriter.write("hha"+i);
			bfWriter.newLine();
			bfWriter.flush();
		}
		bfWriter.close();
		BufferedReader bfReader=new BufferedReader(new FileReader("hah.txt"));
		String line=null;
		int length=0;
		
		while((line=bfReader.readLine())!=null){
			length++;
			//System.out.print((char)line);
		}
		String[] lineArray=new String[length];
		while((line=bfReader.readLine())!=null){
			
			//System.out.print((char)line);
		}
	
		System.out.println(lineArray.toString());
	}
}

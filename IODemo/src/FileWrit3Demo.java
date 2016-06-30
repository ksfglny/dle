import java.io.FileReader;
import java.io.FileWriter;

public class FileWrit3Demo {
	public static void main(String[] args) throws Exception{
		FileWriter fWriter=new FileWriter("demo.txt");
		fWriter.write("abcdec778888");
		fWriter.flush();
		fWriter.close();
		//System.out.println(System.getProperties().toString());
		FileReader fReader=new FileReader("demo.txt");
		int len=0;
		while((len=fReader.read())!=-1){
			System.out.print(String.valueOf((char)len));
		}
		char buff[]=new char[1024];
		while((len=fReader.read(buff))!=-1){
			System.out.println(new String(buff,0,len));
		}
		fReader.close();
	}
}

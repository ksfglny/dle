import java.io.File;

public class FileDemo2 {
	public static void main(String[] args) {
		File file=new File("C:\\Users\\Administrator\\Desktop\\study");
		fileListAll(file,0);
	}
	
	public static void fileListAll(File file,int k) {
		File names[]=file.listFiles();
		for(int i=0;i<k;i++){
			System.out.print("  ");
		}
		System.out.println(file);
		k++;
		for(File name:names){ 
			if (name.isDirectory()) {
				fileListAll(name,k);
			}else{
				for(int i=0;i<k;i++){
					System.out.print("  ");
				}
				System.out.println(name.getName());
			}
			
		}
	}
}

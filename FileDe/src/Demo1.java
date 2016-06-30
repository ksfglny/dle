import java.io.File;

public class Demo1 {
	public static void main(String[] args) throws Exception {
		File file=new File("e:\\");
		
			//file.createNewFile();
			System.out.println(file);
			System.out.println();
			String names[]=file.list();
			System.out.println(names.length);
			for (int i = 0; i < names.length; i++) {
				String string = names[i];
				System.out.println(string);
			}
			System.out.println();
			System.out.println(file.isFile());
			System.out.println(file.isDirectory());
			System.out.println(file.getName());
			System.out.println(file.getPath());
			System.out.println(file.getParent());
			System.out.println(file.getAbsolutePath());
		
	}
}

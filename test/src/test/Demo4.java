package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Demo4 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(new File("C:/Users/Administrator/Desktop/hello.txt")));
		int num = 0;
		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			num++;
		}
		bufferedReader.close();
		BufferedReader bufferedReader2 = new BufferedReader(
				new FileReader(new File("C:/Users/Administrator/Desktop/hello.txt")));
		String[] rows = new String[num];
		String[] names = new String[num];
		for (int i = 0; i < num; i++) {
			rows[i] = bufferedReader2.readLine();
			names[i] = rows[i].substring(rows[i].indexOf(".") + 1, rows[i].indexOf(" "));
		}
		bufferedReader2.close();
		int count[] = new int[num];
		for (int i = 0; i < num; i++) {
			count[i] = 1;
			if (names[i].equals("")) {
				count[i] = 0;
				continue;
			}
			for (int j = i + 1; j < num; j++) {
				if (names[i].equals(names[j])) {
					names[j] = "";
					count[i]++;
				
				}
			}
		}
		for (int i = 0; i < num; i++) {
			names[i] = names[i] + "," + count[i] + "$";
		}
		for (int j = 0; j < num; j++) {
			for (int k = 0; k < num; k++) {
				if (getNum(names[j]) > getNum(names[k])) {
					String tmp = names[j];
					names[j] = names[k];
					names[k] = tmp;
				}
			}
		}
		for (int i = 0; i < num; i++) {
			if (getNum(names[i]) == 0) {
				continue;
			}
			System.out.println(names[i].substring(0, names[i].indexOf("$")));
		}
	}

	static int getNum(String name) {
		return Integer.parseInt(name.substring(name.indexOf(",") + 1, name.indexOf("$")));
	}
}

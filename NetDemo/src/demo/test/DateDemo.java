package demo.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
	public static void main(String[] args) {
		Date date=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyyÄêMMÔÂddÈÕ  hh:mm:ss");
		String time=sd.format(date);
		System.out.println(time);
		System.out.println(date);
				
	}
}

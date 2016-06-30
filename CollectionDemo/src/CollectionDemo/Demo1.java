package CollectionDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Demo1 {
	public static void main(String[] args) {
		ArrayList aList=new ArrayList();
		
		aList.add("123");
		aList.add(1);
		aList.add(true);
		ListIterator iterator=aList.listIterator();
		
		while(iterator.hasNext()){
			sop(iterator.next());
		} 
		sop(aList.size());
		sop(aList.indexOf(true));;
		aList.remove(2);
		sop(aList.size());
		aList.remove(1);
		sop(aList.size());
	}
	public static void sop(Object object){
		System.out.println(object);
	}
}
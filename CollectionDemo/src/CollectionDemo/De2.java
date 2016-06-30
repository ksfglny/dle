package CollectionDemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class De2 {
	public static void main(String[] args) {
		LinkedList ls=new LinkedList();
		String bString="ww";
		sop(bString.hashCode());
		ls.add("java1");
		ls.add("java2");
		ls.add("java3");
		ls.add("java4");
		ls.add("java4");
		ls.add("java2");
		ls.add("java4");
		ls.add("java2");
		sop(Unique(ls));
		Queen queen=new Queen();
		queen.myAdd("lase");
		sop(queen.myGet(0));
		sop(ls.size());
		sop(ls.removeFirst());
		sop(ls.getFirst());
		sop(ls.pop());
		ls.push("haha");
		ls.addLast("peta");
		ListIterator li=ls.listIterator();
		while (li.hasNext()) {
			Object object = (Object) li.next();
			sop(object);
		}
		
		
	}
	public static void sop(Object object){
		System.out.println(object);
	}
	public static LinkedList Unique(LinkedList aList){
		int length=aList.size();
		ListIterator iterator=aList.listIterator();
		for(int i=0;i<length-1;i++){
			for(int j=i+1;j<length;j++){
				if (aList.get(i).equals(aList.get(j))) {
					aList.set(j,"");
				}
			}
		}
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			if (object=="") {
				iterator.remove();
			}
			
		}
		return aList;
	}
}
class Queen{
	private LinkedList ls;
	public Queen(){
		ls=new LinkedList<>();
	}
	public void myAdd(Object object){
		ls.add(object);
	}
	public Object myGet(int i){
		 return ls.get(i);
	}
}
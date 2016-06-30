package CollectionDemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

//hashset test	
public class Demo3 {
	public static void main(String[] args) {
		HashSet hSet=new HashSet();
		TreeSet tSet=new TreeSet<>();
		ArrayList<String> al2=new ArrayList<String>();
		al2.add("qweq");
		al2.add("1231");
		//Iterator<String> it2=al2.iterator();
		for (Iterator iterator = al2.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
			
		}
		tSet.add("asc");
		tSet.add("asas");
		
		hSet.add("java2");
		hSet.add("java2");
		hSet.add("java3");
		hSet.add("java1");
		hSet.add("java4");
		
		for(Iterator it=hSet.iterator();it.hasNext();)
			System.out.println(it.next());
		for(Iterator it2=tSet.iterator();it2.hasNext();)
			System.out.println(it2.next());
		Tool<student> sTool=new Tool<student>();
		sTool.set(new student());
		sTool.get();
		System.out.println(sTool.get().toString());
		
		
	}
	
	
}
class student{
	
}
class Teacher{
	
}
class Tool<T>{
	private T t;
	public void set(T t){
		this.t=t;
	}
	public T get(){
		return t;
	}
}
package day7;

import java.util.ArrayList;

public class Demo2 {
	public static void main(String[] args) {
		ArrayList<Dog> al=new ArrayList<Dog>();
		Dog dog=new Dog();
		al.add(dog);
		Dog tmp=al.get(0);
		String reString=tmp.getClass().getName();
		System.out.println(reString);
		Gen<Dog> gen=new Gen(new Dog());
		reString=gen.getO().getClass().getName();
		System.out.println(reString);
	}

}
class Gen<T>{
	private T o;
	public T getO() {
		return o;
	}
	public void setO(T o) {
		this.o = o;
	}
	public Gen(T t){
		o=t;
		
	}
	
}
class Dog{
	private String name;
	private int age;
	public void  showName() {
		System.out.println("tom");
	}
}
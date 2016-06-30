package duotaiDemo;

public class Demo1 {
	public static void main(String[] args) {
		Dog d1=new Dog(2);
		Dog d2=new Dog(2);
		System.out.println(d1.equals(d2));
	}
}
class Dog{
	
	int num;
	public Dog(int num) {
		// TODO Auto-generated constructor stub
		this.num=num;
	}
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		//Dog dog=(Dog)arg0;
		return this.num==((Dog)arg0).num;
	}
}
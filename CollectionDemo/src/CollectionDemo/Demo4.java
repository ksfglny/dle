package CollectionDemo;

import javax.print.attribute.TextSyntax;

import org.omg.PortableInterceptor.Interceptor;

public class Demo4 {
	public static void main(String[] args) {
	InteIm im=new InteIm();
	im.test("haha");
	Gen<String> gen=new Gen<String>();
	gen.out(123);
	Gen.sprint(123);
	gen.print("1233");
	}
}
interface Itest<T>{
	public void test(T t);
}
class InteIm implements Itest<String>{
	public void test(String t){
		System.out.println(t);
	}
}
class Gen<T>{
	public void out(T t) {
		System.out.println(t);
	}
	public <M> void print(M m){
		System.out.println(m);
	}
	public static <K> void sprint(K k){
		System.out.println(k);
	}
}



public class De1 {
//	
	public static void main(String[] args) {
		Outter.Inner in=new Outter().new Inner();
		in.show();
		Outter outter=new Outter();
		outter.show();
		
		
	}
}
class Outter{
	int x=1;
	int y=2;
	public void show() {
		Inner inner=new Inner();
		inner.show();
	}
	class Inner{
		int y=3;
		int x=4;
		public void show() {
			System.out.println(x);
			System.out.println(y);
			System.out.println(Outter.this.x);
		}
	}
}
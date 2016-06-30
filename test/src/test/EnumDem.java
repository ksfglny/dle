package test;

public class EnumDem {
	public static void main(String[] args) {
		EnumTest.a.getValue();
	}
}
enum  EnumTest{
	a("haha"),b("ahah"),c("pente");
	private  String value;
	EnumTest(String value){
		this.value=value;
	}
	public void getValue(){
		System.out.println(this.value);
	}
	
}
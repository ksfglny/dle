package test.demo;



public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<100;i++){
			sb.append(i);	
		}
		System.out.println(sb.toString());
	
	String s1="";
	for(int i=0;i<100;i++){
		s1=s1+i;
	}
	System.out.println(s1);
}

}
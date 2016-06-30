package day7;


import java.util.Scanner;

public class Transfer {
	public static void main(String[] args) {

		Transfer transfer=new Transfer();
		Scanner scanner=new Scanner(System.in);
		
		while(true){
			String num=scanner.nextLine();
			int res=transfer.jisuan(transfer.zh2(transfer.zh(transfer.ql(num))));
			System.out.println(res);
		}
		//transfer.zh(new Scanner(Stystem.in));
	}
	//�ַ��������и�
	public String[] zh(String num){
		int res=0;
		String unit[]={"��","��","Ǫ","��","ʰ","Բ"};
		int[] xb=new int[unit.length];
		String[] key=new String[unit.length];
		for(int i=0;i<unit.length;i++){	
			if (i==0) {
				xb[i]=num.lastIndexOf(unit[i])<0?0:num.lastIndexOf(unit[i]);
			}else{
				xb[i]=num.substring(xb[i-1],num.length()).lastIndexOf(unit[i])<0?0:num.substring(xb[i-1],num.length()).lastIndexOf(unit[i]);
				if (xb[i]!=0) {
					xb[i]+=xb[i-1];
				}
			}
			
		}
		for(int i=0;i<unit.length;i++){
			if (xb[i]==0) {
				key[i]="��";
			}else{
				if (i==0) {
					key[i]=num.substring(0,xb[i]);
				}else{
					int max=xb[i-1];
					for(int j=0;j<i;j++){
						if (xb[j]>=max) {
							max=xb[j];
						}
					}
					key[i]=num.substring(max==0?0:max+1,xb[i]);
				}
			}
		}
		return key;
	}
	//ȥ����
	public String ql(String str){
		str=str.replace("��",""); 
		return str;
		
	}
	//�����ַ�ת��������
	public int strtoint(String str){
		switch (str) {
		case "��":
			return 0;
		case "Ҽ":
			return 1;
		case "��":
			return 2;
		case "��":
			return 3;
		case "��":
			return 4;
		case "��":
			return 5;
		case "½":
			return 6;
		case "��":
			return 7;
		case "��":
			return 8;
		case "��":
			return 9;
		case "ʰ":
			return 10;
		default:
			return 0;
		}
		
	}
	//������ת�������ж����и�
	public int[]  zh2(String[] key){
		int[] res=new int[key.length];
		for(int i=0;i<key.length;i++){
			if (key[i].length()<=1) {
				res[i]=strtoint(key[i]);
			}else{
				key[i]=key[i].concat("Բ");
				String[] mid=zh(key[i]);
				int[] each=new int[mid.length];
				for(int j=0;j<mid.length;j++){
					each[j]=strtoint(mid[j]);
				}
				res[i]=jisuan(each);
				
			}
		}
//		for(int t=0;t<res.length;t++){
//		System.out.println(res[t]);	
//		}
//		System.exit(0);
		return res;
	}
	public int jisuan(int[] res){
		int out=res[0]*100000000+res[1]*10000+res[2]*1000+res[3]*100+res[4]*10+res[5];
		return out;
	}
	
}

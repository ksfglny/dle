package com.work;
//子线程循环10次，接着主线程循环100，接着又回到子线程循环10次，
//接着再回到主线程又循环100，如此循环50次，请写出程序。
public class HomeWork1   {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean subrunflag=true;
		
		for(int i=0;i<50;i++){
			if (subrunflag) {
				try {
					Thread t1=new Thread(new subThread());
					t1.start();
					t1.join();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				subrunflag=false;
			}else{
				for(int j=0;j<100;j++){
					System.out.println(Thread.currentThread().getName()+":"+j);
				}
				subrunflag=true;
				
			}
		}
		
	}
}
class subThread implements Runnable{
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}

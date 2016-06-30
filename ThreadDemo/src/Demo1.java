class Demo implements  Runnable {
	int tick=100;
	
	//Object object=new Object();
	public  void run() {
		
		while(true){
			work();
		}
		
	}
	public synchronized void work(){
	if (tick>0) {
		
	
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"-"+tick--);
		}
	}
}

public class Demo1 {
	public static void main(String[] args) {
		Demo demo=new Demo();
		Thread t1=new Thread(demo);
		Thread t2=new Thread(demo);
		Thread t3=new Thread(demo);
		Thread t4=new Thread(demo);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
	}
}

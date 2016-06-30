
public class ThreadDemoYelid {
	public static void main(String[] args) {
		Demob  demo=new Demob();
		Thread t1=new Thread(demo);
		Thread t2=new Thread(demo);
		t1.start();
//		try {
//			t1.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		t2.start();
	}
}
class Demob implements Runnable{
	public void run(){
		for(int i=0;i<50;i++){
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			Thread.yield();
			System.out.println(Thread.currentThread().toString()+i);
			//Thread.yield();
		}
	}
}

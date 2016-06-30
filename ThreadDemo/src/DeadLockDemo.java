
public class DeadLockDemo {
	public static void main(String[] args) {
		Thread t1=new Thread(new ThreadDemo(true));
		Thread t2=new Thread(new ThreadDemo(false));
		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}
}
class ThreadDemo implements Runnable{
	boolean f;
	public ThreadDemo(Boolean flag) {
		this.f=flag;
		// TODO Auto-generated constructor stub
	}
	public void run(){
		while(true){
		if (f==true) {
			synchronized (Lock.locka) {
				System.out.println(Thread.currentThread().getName()+"locka");
				synchronized (Lock.lockb) {
					System.out.println(Thread.currentThread().getName()+"lockb");
				}
			}
		}else{
			synchronized (Lock.lockb) {
				System.out.println(Thread.currentThread().getName()+"lockb");
				synchronized (Lock.locka) {
					System.out.println(Thread.currentThread().getName()+"locka");
				}
			}
		}
	}
	}
}
class Lock{
	static Object locka=new Object();
	static Object lockb=new Object();
}
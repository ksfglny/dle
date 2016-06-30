import java.util.concurrent.locks.*;

public class ThreadComDemo {
	
	public static void main(String[] args) {
		Res res=new Res();
		Thread t1=new Thread(new input(res));
		Thread t5=new Thread(new input(res));
		Thread t2=new Thread(new input(res));
		Thread t3=new Thread(new output(res));
		Thread t4=new Thread(new output(res));
	
		
		t3.start();
		t4.start();
		t1.start();
		t2.start();
		t5.start();
	
	}
}
class Res{
	private String name;
	private String sex;
	public boolean flag=false;
	public int x;
	public boolean y;
	private ReentrantLock lock=new ReentrantLock();
	private Condition c_input=lock.newCondition();
	private Condition c_output=lock.newCondition();
	public synchronized void set(){
		lock.lock();
		try {
			while(true){
				if (flag) {
					try {
						c_input.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					flag=true;
//					try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					if (y) {
						name="jack";
						sex="man";
						System.out.println(Thread.currentThread().getName()+"shengchan"+name+"---"+sex+"---"+x);
						c_output.signal();
						y=false;
					}else{
						name="rose";
						sex="woman";
						System.out.println(Thread.currentThread().getName()+"shengchan"+name+"---"+sex+"---"+x);
						c_output.signal();
						y=true;
					}
					
				}
			}
		} finally {
			// TODO: handle finally clause
			//lock.unlock();
		}
		
		
	}
	public  void get() {
		lock.lock();
		try {
			while(true){
				if (flag) {
					System.out.println(Thread.currentThread().getName()+name+"---"+sex+"---"+x++);
					c_input.signal();
					flag=false;
				}else{
					try {
						c_output.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		} finally {
			// TODO: handle finally clause
			//lock.unlock();
		}
	}	
	
}
class input implements Runnable{
	private Res r;
	public input(Res r) {
		// TODO Auto-generated constructor stub
		this.r=r;	
	}
	public void run(){
		r.set();
	}
	
}
class output implements Runnable{
	private Res r;
	public output(Res r) {
		// TODO Auto-generated constructor stub
		this.r=r;
		
	}
	public void run(){
		r.get();
	}
}
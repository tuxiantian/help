package tuxt.springthreaddemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo implements Runnable{

	private ReentrantLock lock=new ReentrantLock();
	private Condition condition=lock.newCondition();
	private int state=0;
	
	public static void main(String[] args) {
		ThreadDemo task=new ThreadDemo();
		Thread thread1=new Thread(task);
		Thread thread2=new Thread(task);
		Thread thread3=new Thread(task);
		thread1.setName("a");
		thread2.setName("b");
		thread3.setName("c");
		thread1.start();
		thread2.start();
		thread3.start();
	}

	@Override
	public void run() {
		String name=Thread.currentThread().getName();
		lock.lock();
		try {
			for (int i = 0; i < 10; i++) {
				if ("b".equals(name)) {
					while (state%3!=1) {
						condition.await();
					}
				}
				if ("c".equals(name)) {
					while(state%3!=2){
						condition.await();
					}
				}
				if ("a".equals(name)) {
					while (state%3!=0) {
						condition.await();
					}
				}
				state++;
				System.out.print(name);
				condition.signalAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}

}

package tuxt.threadpool.test;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestScheduledThreadPoolExecutor {
	public static void main(String[] args) {
		ScheduledThreadPoolExecutor exec=new ScheduledThreadPoolExecutor(1);
		exec.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				System.out.println("----------------------");		
			}
		}, 1000, 500, TimeUnit.MILLISECONDS);
		exec.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println(new Date());
			}
		}, 1000, 500, TimeUnit.MILLISECONDS);
	}
}

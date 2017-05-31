package tuxt.help.thread.test;

public class ThreadDieSockTest {

	public static void main(String[] args) {
		 ThreadLocal<Integer> local=new ThreadLocal<Integer>();
		  ThreadDieSock2 run01 = new ThreadDieSock2();
	        ThreadDieSock2 run02 = new ThreadDieSock2();
			/* run01.flag = 1;
	        run02.flag = 0;*/
	       
	        local.set(1);
	        run01.setLocal(local);
	        local.set(0);
	        run02.setLocal(local);
	        Thread thread01 = new Thread(run01);
	        Thread thread02 = new Thread(run02);
	        System.out.println("线程开始喽！");
	        thread01.start();
	        thread02.start();
	}

}

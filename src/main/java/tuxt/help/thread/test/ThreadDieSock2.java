package tuxt.help.thread.test;


public class ThreadDieSock2 implements Runnable {
	
    private int flag = 1;
    ThreadLocal<Integer> local;
   
    public ThreadLocal<Integer> getLocal() {
		return local;
	}

	public void setLocal(ThreadLocal<Integer> local) {
		this.local = local;
	}

	private Object obj1 = new Object(), obj2 = new Object();

    public void run() {
        System.out.println("flag=" + local.get());
        
        if (local.get() == 1) {
            synchronized (obj1) {
                System.out.println("我已经锁定obj1，休息0.5秒后锁定obj2去！");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println("1");
                }
            }
        }
        if (local.get() == 0) {
            synchronized (obj2) {
                System.out.println("我已经锁定obj2，休息0.5秒后锁定obj1去！");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) {
      
    }
}
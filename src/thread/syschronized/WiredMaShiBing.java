package thread.syschronized;
public class WiredMaShiBing implements Runnable {
	int b = 100;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getPriority());
            m1();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
	
	public synchronized void m1() throws Exception{
		// Thread.sleep(2000);
        // m1线程把b改成5000ms后睡眠5000ms
		b = 1000;
		Thread.sleep(5000);
	    System.out.println("b(m1) = " + b);
	}
	
	public synchronized void m2() throws Exception {
	    // 主线程2500ms后把b改成2000
		Thread.sleep(4000);
		b = 2000;
	}
	
	public static void main(String[] args) throws Exception {
		WiredMaShiBing tt = new WiredMaShiBing();
		Thread t = new Thread(tt);
//      t线程后获得对象锁
		t.start();
		
//		主线程先获得对象锁
		tt.m2();
		System.out.println(tt.b);
	}
}
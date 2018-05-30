package thread.syschronized;
class MyThread2 implements Runnable{	// 继承Thread类，作为线程的实现类
	private int ticket = 5 ;		// 表示一共有5张票
	public void run(){	// 覆写run()方法，作为线程 的操作主体
		for(int i=0;i<100;i++){
			if(this.ticket>0){
				System.out.println("卖票：ticket = " + ticket--) ;
			}
		}
	}
};
public class SaleTicketDemo{
	public static void main(String args[]){
		MyThread2 mt = new MyThread2() ;	 // 实例化对象
		new Thread(mt).run() ;	// 调用线程主体
		new Thread(mt).run() ;	// 调用线程主体
		new Thread(mt).run() ;	// 调用线程主体
	}
};
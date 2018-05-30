package thread;
class MyThread1 extends Thread{	// 继承Thread类，作为线程的实现类
	
	private int ticket = 5 ;		// 表示一共有5张票
	public void run(){	// 覆写run()方法，作为线程 的操作主体
		for(int i=0;i<100;i++){
			if(this.ticket>0){
				System.out.println("卖票：ticket = " + ticket--) ;
			}
		}
	}
};
public class ThreadDemo04{
	public static void main(String args[]){
		MyThread1 mt1 = new MyThread1() ;	 // 实例化对象
		MyThread1 mt2 = new MyThread1() ;	 // 实例化对象
		MyThread1 mt3 = new MyThread1() ;	 // 实例化对象
		mt1.start(); // 调用线程主体
		mt2.start(); // 调用线程主体
		mt3.start(); // 调用线程主体
	}
};
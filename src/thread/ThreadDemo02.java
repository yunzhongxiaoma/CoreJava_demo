package thread;
class MyThread0 extends Thread{	// 继承Thread类，作为线程的实现类
	private String name ;		// 表示线程的名称
	public MyThread0(String name){
		this.name = name ;		// 通过构造方法配置name属性
	}
	public void run(){	// 覆写run()方法，作为线程 的操作主体
		for(int i=0;i<10;i++){
			System.out.println(name + "运行，i = " + i) ;
		}
	}
};
public class ThreadDemo02{
	public static void main(String args[]){
		MyThread0 mt1 = new MyThread0("线程A ") ;	 // 实例化对象
		MyThread0 mt2 = new MyThread0("线程B ") ;	 // 实例化对象
		mt1.start() ;	// 调用线程主体
		mt2.start() ;	// 调用线程主体
	}
};
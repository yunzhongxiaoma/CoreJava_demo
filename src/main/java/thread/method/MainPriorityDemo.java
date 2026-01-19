package main.java.thread.method;
public class MainPriorityDemo{
	public static void main(String args[]){
		System.out.println("主方法的优先级：" + 
			Thread.currentThread().getPriority()) ;	// 取得主方法的优先级
		System.out.println("MAX_PRIORITY = " + Thread.MAX_PRIORITY) ;
		System.out.println("NORM_PRIORITY = " + Thread.NORM_PRIORITY) ;
		System.out.println("MIN_PRIORITY = " + Thread.MIN_PRIORITY) ;
	}
};


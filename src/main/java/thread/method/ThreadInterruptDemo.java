package main.java.thread.method;

class MyThread5 implements Runnable { // 实现Runnable接口
    public void run() { // 覆写run()方法
        System.out.println("1、进入run()方法");
        try {
            Thread.sleep(10000); // 线程休眠10秒
            System.out.println("2、已经完成了休眠");    //将没有机会执行,便被打断
        } catch (InterruptedException e) {
            System.out.println("3、休眠真正被终止（run方法体里）");
            return; // 返回调用处
        }
        System.out.println("4、run()方法正常结束");
    }
};

public class ThreadInterruptDemo {
    public static void main(String args[]) {
        // 必须运行
        MyThread5 mt = new MyThread5(); // 实例化Runnable子类对象
        Thread t = new Thread(mt, "线程"); // 实例化Thread对象
        t.start(); // 启动线程
        try {
            Thread.sleep(2000); // 主线程休眠2秒
        } catch (InterruptedException e) {
        }
        System.out.println("中断之前");
        t.interrupt(); // 中断线程执行，主线程开始执行打断线程mt的操作
        System.out.println("3、休眠被终止（main）");
        System.out.println("中断之后");
    }
};

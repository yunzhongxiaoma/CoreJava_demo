package main.java.thread.method;
/**
 * Interrupt不是停止线程最好的方法，太粗暴了，万一有线程打开了一个资源，没来得及关闭，被你终止怎么办
 * 就像人家睡着了，你咣当一盆凉水泼上去，谁受得了
 * 尽量更不要使用stop方法，这更粗暴，直接一根棒子打死，连捕获异常处理关闭资源的机会都没有
 * 最好的办法见com.yunzhongxiaoma.main.java.thread.method/ThreadStopDemo.java
 * @param 
 * 2018下午7:05:59
 */
class MyThread4 implements Runnable { // 实现Runnable接口
    public void run() { // 覆写run()方法
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(500); // 线程休眠
            } catch (InterruptedException e) {
            }
            
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i); // 取得当前线程的名字
        }
    }
};

public class ThreadSleepDemo {
    public static void main(String args[]) {
        MyThread4 mt = new MyThread4(); // 实例化Runnable子类对象
        Thread t = new Thread(mt, "线程"); // 实例化Thread对象
        t.start(); // 启动线程
    }
};

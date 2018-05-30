package thread.method;

class MyThread10 implements Runnable { // 实现Runnable接口
    public void run() { // 覆写run()方法
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
            // 取得当前线程的名字
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i);
            if (i == 2) {
                System.out.print(Thread.currentThread().getName() + "礼让：\n");
                Thread.currentThread().yield(); // 线程礼让
            }
        }
    }
};

public class ThreadYieldDemo {
    public static void main(String args[]) {
        MyThread10 my = new MyThread10(); // 实例化MyThread对象
        Thread t1 = new Thread(my, "线程A");
        Thread t2 = new Thread(my, "线程B");
        t1.start();
        t2.start();
    }
};

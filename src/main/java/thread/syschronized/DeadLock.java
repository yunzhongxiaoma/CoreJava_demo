package main.java.thread.syschronized;

class Zhangsan { // 定义张三类
    public void say() {
        System.out.println("张三对李四说：“你给我画，我就把书给你。”");
    }

    public void get() {
        System.out.println("张三得到画了,准备把画给李四。");
    }
};

class Lisi { // 定义李四类
    public void say() {
        System.out.println("李四对张三说：“你给我书，我就把画给你”");
    }

    public void get() {
        System.out.println("李四得到书了,准备把画给张三。");
    }
};

public class DeadLock implements Runnable {
    private static Zhangsan zs = new Zhangsan(); // 实例化static型对象
    private static Lisi ls = new Lisi(); // 实例化static型对象
    private boolean flag = false; // 声明标志位，判断那个先说话

    public void run() { // 覆写run()方法
        if (flag) {
            synchronized (zs) { // 同步张三,锁住张三这个对象
                zs.say();
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (ls) { // 只要能同步李四,锁住李四这个对象之后，就能执行zs.get()
                    zs.get();
                }
            }
        } else {
            synchronized (ls) {
                ls.say();
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (zs) {
                    ls.get();
                }
            }
        }
    }

    public static void main(String args[]) {
        DeadLock t1 = new DeadLock();
        DeadLock t2 = new DeadLock();
        t1.flag = true;
        t2.flag = false;
        Thread thA = new Thread(t1, "张三");
        Thread thB = new Thread(t2, "李四");
        thA.start();
        thB.start();
    }
};

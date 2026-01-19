package main.java.thread.method;

import java.util.Date;

public class ThreadStopDemo {

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo threadDemo = new ThreadDemo();
        new Thread(threadDemo).start();
        Thread.sleep(3000);
        //停止while循环
        threadDemo.flag = false;
    }

}

class ThreadDemo extends Thread{
    boolean flag = true;
    
    @Override
    public void run() {
        while (flag) {
            System.out.println(new Date());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

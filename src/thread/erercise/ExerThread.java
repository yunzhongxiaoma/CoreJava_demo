package thread.erercise;

public class ExerThread {
    public static void main(String[] args) {
        Thread11 A = new Thread11("线程A", 1000);
        Thread11 B = new Thread11("线程B", 2000);
        Thread11 C = new Thread11("线程C", 3000);
        C.start();
        A.start();
        B.start();

    }
}

class Thread11 extends Thread {
    private int time;

    public Thread11(String name, int time) {
        super(name);    // new skill
        this.time = time;
    }

    @Override
    public void run() {
        try {
//            Thread.yield();
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "休眠" + this.time + "ms后开始运行。");
    }
}
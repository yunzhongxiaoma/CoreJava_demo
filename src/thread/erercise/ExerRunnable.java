package thread.erercise;

public class ExerRunnable {
    public static void main(String[] args) {
        Thread A = new Thread(new Thread12(1000), "A");
        Thread B = new Thread(new Thread12(2000), "B");
        Thread C = new Thread(new Thread12(3000), "C");
        A.start();
        B.start();
        C.start();
    }
}

class Thread12 implements Runnable {
    private int time;

    public Thread12(int time) {
        super();
        this.time = time;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "休眠" + this.time + "ms后开始运行。");
    }
}
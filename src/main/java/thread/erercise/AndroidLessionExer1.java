package main.java.thread.erercise;

public class AndroidLessionExer1 {
    
    public static void main(String[] args) {
        Thread task = new Machine();
        task.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }
}


class Machine extends Thread{
    @Override
    public void run() {
        long number = 1;
        while (true) {
            if (isPrime(number)) {
                // "%d"表示输出十进制整数
                System.out.printf("Number %d is machine \n", number);
            }
            if (isInterrupted()) {
                System.out.printf("The machine has been interrupted");
                return;
            }
            number++;
        }
    }
    
    private boolean isPrime(long number) {
        number = number + 2;
        return true;
    }
}

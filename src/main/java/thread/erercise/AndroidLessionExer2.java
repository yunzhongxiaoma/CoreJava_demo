package main.java.thread.erercise;
/**
 * @author yunzhongxiaoma
 * 参考本包BracketsTest.java、anonymous包匿名内部类
 * 结论：1.多了一种启动线程的方式 new Thread() {重写run方法}.start();
 *     2.new Thread(target) {重写run方法}.start();
 */
public class AndroidLessionExer2 {
    public static void main(String[] args) {
        Runnable runner1 = new Runnable() {
            @Override
            public void run() {
                // 重写Runnable接口的run方法
                while (true) {
                    try {
                        new Thread().sleep(500);
                        System.out.println("Android--runnable->" + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        
        new Thread(runner1) {

            @Override
            public void run() {
                // 重写Thread类的run方法
                while (true) {
                    try {
                        new Thread().sleep(1000);
                        System.out.println("李华--main.java.thread.run->" + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
        }.start();
        
    }
}

package main.java.thread.threadPoolExecutor;

import java.util.concurrent.*;

/**
 * JDK自带ScheduledThreadPoolExecutor是ThreadPoolExecutor的子类，专门处理定时/周期性任务
 */
public class ScheduledThreadPoolDemo {
    public static void main(String[] args) {
        // 1.创建定时线程池（核心参数：核心线程数=2，其他参数默认即可）
        ScheduledExecutorService scheduledPool = new ScheduledThreadPoolExecutor(
                2,  // 核心线程数
                new ThreadFactory() {  // 自定义线程工厂，命名线程
                    private int count = 0;
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("定时任务线程-" + (++count));
                        return thread;
                    }
                },
                new ThreadPoolExecutor.CallerRunsPolicy()  // 拒绝策略：调用线程执行
        );

        // 2.任务1：延迟1秒执行（解决“延迟执行一次性任务”问题）
        scheduledPool.schedule(() -> {
            System.out.println(Thread.currentThread().getName() + "：延迟1秒执行，时间=" + System.currentTimeMillis());
        }, 1, TimeUnit.SECONDS);

        // 3.任务2：延迟2秒后，每3秒执行一次（解决“周期性执行任务”问题）
        // 注意：scheduleAtFixedRate是“固定频率”，无论任务执行多久，间隔是固定的；
        //      scheduleWithFixedDelay是“固定延迟”，任务执行完后等指定时间再执行
        ScheduledFuture<?> future = scheduledPool.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName() + "：周期执行，时间=" + System.currentTimeMillis());
            // 模拟任务执行耗时
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 2, 3, TimeUnit.SECONDS);

        // 4.运行10秒后关闭线程池（工程中需手动关闭，避免内存泄漏）
        try {
            Thread.sleep(10000);
            future.cancel(false);  // 取消周期性任务
            scheduledPool.shutdown();  // 优雅关闭：等待已提交任务执行完
            // 等待线程池关闭（超时控制，避免卡死）
            if (!scheduledPool.awaitTermination(3, TimeUnit.SECONDS)) {
                scheduledPool.shutdownNow();  // 强制关闭
            }
        } catch (InterruptedException e) {
            scheduledPool.shutdownNow();
        }
    }

    /*解决的核心问题：替代Timer（单线程，任务异常会导致整个Timer挂掉），实现多线程安全的定时/周期任务；
    工程注意点：
    定时任务必须捕获所有异常，否则单个任务异常会导致该线程终止，后续周期任务不再执行；
    线程池必须手动关闭（shutdown()/shutdownNow()），否则程序不会退出；
    周期任务优先用scheduleWithFixedDelay（更符合业务预期，避免任务叠加）。
    */
}
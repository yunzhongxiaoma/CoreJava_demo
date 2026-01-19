package main.java.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    // 1.创建可重入锁（默认非公平锁；公平锁：new ReentrantLock(true)）
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        // 2.线程1：加锁+释放锁（基础用法）
        new Thread(() -> {
            lock.lock();  // 加锁（必须手动释放，否则死锁）
            try {
                System.out.println(Thread.currentThread().getName() + "：获取锁，执行任务");
                // 可重入：同一线程可多次加锁
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "：再次获取锁（可重入）");
                } finally {
                    lock.unlock();  // 释放第二次加的锁
                }
            } finally {
                lock.unlock();  // 释放第一次加的锁（必须在finally中，避免异常导致锁不释放）
            }
        }, "线程1").start();

        // 3.线程2：尝试获取锁（超时控制，解决“死等锁”问题）
        new Thread(() -> {
            boolean isLock = false;
            try {
                // 尝试获取锁，5秒超时，超时后放弃（synchronized无此功能）
                isLock = lock.tryLock(5, TimeUnit.SECONDS);
                if (isLock) {
                    System.out.println(Thread.currentThread().getName() + "：获取锁成功");
                } else {
                    System.out.println(Thread.currentThread().getName() + "：5秒未获取锁，放弃");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (isLock) {
                    lock.unlock();  // 仅获取锁成功才释放
                }
            }
        }, "线程2").start();
    }
}
/*
#### 工程核心场景（解决什么问题）
1. **超时获取锁**：避免线程死等（如`tryLock()`），解决“synchronized死锁风险”；
2. **公平锁**：`new ReentrantLock(true)`，解决“线程饥饿”问题（每个线程按顺序获取锁）；
3. **条件变量**：`lock.newCondition()`，实现精准唤醒线程（如生产者消费者模型，替代`wait/notify`）；
4. **可中断锁**：`lock.lockInterruptibly()`，解决“线程等待锁时可被中断”的问题。
*/

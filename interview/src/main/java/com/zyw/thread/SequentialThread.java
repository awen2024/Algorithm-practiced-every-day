package com.zyw.thread;

public class SequentialThread {

    public static void main(String[] args) {
        final Object lock = new Object();
        final int[] state = {1};

        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 1");
                state[0] = 2; // 更新状态为2，表示Thread 1完成，Thread 2可以开始
                lock.notifyAll(); // 唤醒所有等待的线程
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                while (state[0] != 2) { // 等待Thread 1完成
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Thread 2");
                state[0] = 3; // 更新状态为3，表示Thread 2完成，Thread 3可以开始
                lock.notifyAll(); // 唤醒所有等待的线程
            }
        });

        Thread thread3 = new Thread(() -> {
            synchronized (lock) {
                while (state[0] != 3) { // 等待Thread 2完成
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Thread 3");
                // 此时所有线程均已完成
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

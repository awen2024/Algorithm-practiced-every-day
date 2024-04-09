package com.zyw.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchThread {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1");
            latch1.countDown(); // 让latch1计数减1
        });

        Thread thread2 = new Thread(() -> {
            try {
                latch1.await(); // 等待latch1变为0
                System.out.println("Thread 2");
                latch2.countDown(); // 让latch2计数减1
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                latch2.await(); // 等待latch2变为0
                System.out.println("Thread 3");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

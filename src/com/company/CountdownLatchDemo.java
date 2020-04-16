package com.company;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchDemo {
     public static void main(String[] args) throws InterruptedException {
         CountDownLatch countDownLatch = new CountDownLatch(6);

         for (int i = 1; i <= 6; i++) {
             new Thread(()->{
                 System.out.println(Thread.currentThread().getName()+"\t leave room.");
                 countDownLatch.countDown();
             },String.valueOf(i)).start();
         }

         countDownLatch.await();
         System.out.println(Thread.currentThread().getName()+"\t  last one close door.");
     }
}

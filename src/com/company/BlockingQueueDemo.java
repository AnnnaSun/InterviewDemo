package com.company;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args){

//        BlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
//
//        System.out.println(blockingQueue.add("A"));
//        System.out.println(blockingQueue.add("B"));
//        System.out.println(blockingQueue.add("C"));
//        System.out.println(blockingQueue.add("X"));
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
        BlockingQueue blockingQueue = new SynchronousQueue();
        new Thread(() ->{
            try {
                System.out.println(Thread.currentThread().getName()+"\t put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"\t put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"\t put 3");
                blockingQueue.put("3");
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }, "AAA").start();

        new Thread(() ->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"\t "+blockingQueue.take());
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }, "BBB").start();

    }
}

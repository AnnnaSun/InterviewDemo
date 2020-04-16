package com.company;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
//自旋锁实现
public class DemoLock {
    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void mylock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t come in......");
        while(!atomicReference.compareAndSet(null,thread))
        {

        }
    }

    public void unlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName()+"\t come out......");
    }
//    public static void main(String[] args){
//        DemoLock demoLock = new DemoLock();
//
//        new Thread(() ->{
//            demoLock.mylock();
//
//            //暂停一会儿锁
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            demoLock.unlock();
//        },"AA").start();
//
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//
//        new Thread(() ->{
//            demoLock.mylock();
//            demoLock.unlock();
//        },"BB").start();
//    }
}

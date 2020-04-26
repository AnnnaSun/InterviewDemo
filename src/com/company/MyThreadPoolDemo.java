package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolDemo {
    public static void main(String[] args){
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池5线程
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //模拟10个人办理业务，5个窗口
        try {
                for (int i = 1; i < 11; i++) {
                    threadPool.execute(()->{
                        System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                    });
//                    try {
//                        TimeUnit.MILLISECONDS.sleep(200);
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
                }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}

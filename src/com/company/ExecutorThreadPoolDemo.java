package com.company;

import java.util.concurrent.*;

public class ExecutorThreadPoolDemo {

    public static void main(String[] args){
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );

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
    public static void threadPoolInit(){

    }
}

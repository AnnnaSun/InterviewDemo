package com.company;

import java.sql.PreparedStatement;
import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource{
    private volatile boolean Flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;
    private MyResource myResource;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    //生产
    public void myProd() throws Exception{
        String data = null;
        boolean retvalue ;
        while (Flag){
            data = atomicInteger.incrementAndGet()+"";
            retvalue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retvalue){
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+ data+"成功");
            }
            else {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+ data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName()+"\t 生产叫停");
        }
    }

    //消费
    public void myconsumer() throws Exception{
        String result = null;
        boolean retvalue;
        while (Flag){
            result = blockingQueue.poll(2l, TimeUnit.SECONDS);
            if (null == result|| result.equalsIgnoreCase("")){
                Flag = false;
                System.out.println(Thread.currentThread().getName()+"\t 超过两秒没有取得产品，消费停止");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t 消费队列"+ result+ "成功。");
        }
    }

    public void stop() throws Exception{
        this.Flag = false;
    }

}
public class ProdConsumer_BlockQueueDemo {
    public static void main(String[] args){
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()-> {
            System.out.println(Thread.currentThread().getName()+"\t 生产线启动");
            try {
                myResource.myProd();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"Prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 消费线启动");
            try {
                myResource.myconsumer();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"Consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("5s时间到，消费生产线全部暂停");
        try {
            myResource.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

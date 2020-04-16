package com.company;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//一个初始值为0的变量，两个线程交替操作，一个加一个减，循环5次
class ShareData{
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception{
        lock.lock();
        try {
            //判断
            while(num!=0){
                //等待，不能生产
                condition.await();
            }
            //加一
            num++;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            //通知唤醒
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void decrement() throws Exception{
        lock.lock();
        try {
            //判断
            while(num==0){
                //等待，不能消费
                condition.await();
            }
            //减一
            num--;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            //通知唤醒
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
public class ProdConsumer_TraditionDemo {

    public static void main(String[] args){
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();

    }
}

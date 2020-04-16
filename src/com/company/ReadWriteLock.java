package com.company;

import javax.naming.event.ObjectChangeListener;
import javax.swing.plaf.basic.BasicTreeUI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache{
    private  volatile Map<String, Object> map = new HashMap<>();
    private Lock lock = new ReentrantLock();
    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

    public void put(String key, Object object){
        rwlock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在写入:"+key);
            try{
                TimeUnit.MICROSECONDS.sleep(300);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            map.put(key, object);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成！！！！");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwlock.writeLock().unlock();
        }

    }

    public void get(String key){
        rwlock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在读取:");
            try{
                TimeUnit.MICROSECONDS.sleep(300);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            Object obj = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成！！！！"+obj);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwlock.readLock().unlock();
        }

    }
}
public class ReadWriteLock {
    public static void main(String[] args){
        MyCache myCache = new MyCache();
        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(() ->{
                myCache.put(temp+"", temp+"");
            }, String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(() ->{
                myCache.get(temp+"");
            }, String.valueOf(i)).start();
        }
    }
}

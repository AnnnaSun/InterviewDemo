package com.company;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//三个线程按照顺序启动：AA5次，BB10次，CC15次。循环10次

class ShareResource{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    //判断
    public void print5(){
        lock.lock();
        try {
            while(number!=1){
                c1.await();
            }
            for (int i=1;i<=5;i++){
                System.out.println(Thread.currentThread().getName()+"\t "+i);
            }
            number = 2;
            c2.signal();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try {
            while(number!=2){
                c2.await();
            }
            for (int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+"\t "+i);
            }
            number = 3;
            c3.signal();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try {
            while(number!=3){
                c3.await();
            }
            for (int i=1;i<=15;i++){
                System.out.println(Thread.currentThread().getName()+"\t "+i);
            }
            number = 1;
            c1.signal();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}
public class SyncReentranLockDemo {

    public static void main(String[] args){
        ShareResource shareResource = new ShareResource();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                shareResource.print5();
            },"AA").start();
            new Thread(()->{
                shareResource.print10();
            },"BB").start();
            new Thread(()->{
                shareResource.print15();
            },"CC").start();
        }

    }
}

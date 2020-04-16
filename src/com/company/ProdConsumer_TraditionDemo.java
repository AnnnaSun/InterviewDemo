package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//一个初始值为0的变量，两个线程交替操作，一个加一个减，循环5次
class ShareData{
    private int num = 0;
    private Lock lock = new ReentrantLock();

    public void increment() throws Exception{
        //判断
        while(num!=0){
            //等待，不能生产
        }
    }
}
public class ProdConsumer_TraditionDemo {

    public static void main(String[] args){

    }
}

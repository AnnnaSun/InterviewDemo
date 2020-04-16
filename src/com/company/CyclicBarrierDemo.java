package com.company;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args){

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{System.out.println("直到完成才会出现");});

        for (int i = 1; i <= 7; i++) {
            final int intTemp = i;
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName()+"\t 报数:"+intTemp);
                try {
                    cyclicBarrier.await();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }catch (BrokenBarrierException e){
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}

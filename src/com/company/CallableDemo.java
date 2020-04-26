package com.company;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class MyThread implements Runnable{

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"*****************come in");
        return 1024;
    }
}
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        new Thread(futureTask,"AAA").start();
        new Thread(futureTask,"BB").start();
        int result1 = 100;
//        while (!futureTask.isDone()){
//
//        }
        System.out.println(Thread.currentThread().getName()+"*************");
        System.out.println("result"+ futureTask.get());
    }
}

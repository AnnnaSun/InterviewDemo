package com.company;
//饿汉式
//public class Singleton {
//    public static final Singleton INSTANCE = new Singleton();
//    private Singleton(){
//
//    }
//
//    public enum Singleton2{
//        INSTANCE;
//    }
//
//}
//懒汉式
//public class Singleton4{
//    private static Singleton4 instance;
//    private Singleton4(){
//
//    }
//    public static Singleton4 getInstance(){
//        if (instance == null){
//            instance = new Singleton4();
//        }
//        return instance;
//    }
//}

import com.sun.source.tree.BreakTree;

//线程安全的懒汉式
//public class Singleton5{
//    private static Singleton5 instance;
//    private Singleton5(){
//
//    }
//    public static Singleton5 getInstance() {
//        synchronized (Singleton5.class) {
//            if (instance == null) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                instance = new Singleton5();
//            }
//        }
//        return instance;
//    }
//
//}


package com.company;

public class StrongReferenceDemo {

    public static void main(String[] args){
        Object obj1 = new Object();//这样的定义默认是强引用
        Object obj2 = obj1;//obj2引用赋值
        obj1=null;//置空
        System.gc();
        System.out.println(obj2);//obj2依旧存在，即使obj1置空，不会被垃圾回收影响
    }
}

package com.company;

public class GCrootDemo {
    private byte[] byteArray = new byte[100*1024*1024];

    public static void m1(){
        GCrootDemo t1 = new GCrootDemo();
        System.gc();
        System.out.println("完成第一次GC");
    }

    public static void main(String[] args){
        m1();
    }
}

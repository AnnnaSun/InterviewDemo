package com.company.test;

public class FatherDemo {
    private int i = test();
    private static int j = method();
    static {
        System.out.print(" 1 ;");
    }
    FatherDemo(){
        System.out.print(" 2 ;");
    }
    {
        System.out.print(" 3 ;");
    }
     public int test(){
        System.out.print(" 4 ;");
        return 1;
     }
     public static int method(){
        System.out.print(" 5 ;");
        return 2;
     }
}
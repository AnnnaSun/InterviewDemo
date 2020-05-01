package com.company.test;

import jdk.jfr.StackTrace;

//求N步台阶只能走1,2步，有多少种选择
public class Exam2 {

    //递归，可读性高
//    public static int f(int n){
//        if (n<1){
//            throw new IllegalArgumentException("台阶不能小于1");
//        }
//        if (n==1 || n==2){
//            return n;
//        }
//        return f(n-1)+f(n-2);
//    }

    public static int f(int n){
        int one = 1;
        int two = 2;//初始化，走到1,2级台阶的步数选择
        int sum = 0;

        if (n<1){
            throw new IllegalArgumentException("台阶不能小于1");
        }
        if (n ==1 || n==2){
            return n;
        }

        for (int i = 3; i < n; i++) {
            sum = one+two;
            two = one;
            one = sum;
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println(f(1));
        System.out.println(f(2));
        System.out.println(f(11));
    }
}

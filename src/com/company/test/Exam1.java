package com.company.test;

public class Exam1 {
    public static void main(String[] args){
        int i  = 1;
        String s = "hello";
        Integer num = 200;
        int[] arr = {1,2,3,4,5};
        MyData my = new MyData();

        change(i, s, num, arr, my);
        System.out.println("i = "+i);
        System.out.println("str = "+s);
        System.out.println("num = "+num);
        System.out.println("arr = "+arr);
        System.out.println("my.a = "+my.a);

    }
    public static void change(int j, String s, Integer n, int[] a, MyData m){
        j += 1;
        s +="world";
        n +=1;
        a[0] +=1;
        m.a +=1;
    }
}
class MyData{
    int a = 10;
}

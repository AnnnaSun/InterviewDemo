package com.company.test;

public class Exam3 {
    static int s;//类变量
    int i;//成员变量，实例对象
    int j;//成员变量
    {
        int i = 1;//非静态代码块的局部变量
        i++;
        j++;
        s++;
    }
    public void test(int j){//形参，局部变量
        j++;
        i++;
        s++;
    }
    public static void main(String[] args){
        Exam3 obj1 = new Exam3();//局部变量
        Exam3 obj2 = new Exam3();//局部变量
        obj1.test(10);
        obj1.test(20);
        obj2.test(30);
        System.out.println(obj1.i+","+obj1.j+","+obj1.s);
        System.out.println(obj2.i+","+obj2.j+","+obj2.s);
    }
}

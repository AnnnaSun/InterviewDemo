package com.company.test;

public class SonDemo extends FatherDemo {
    private int i = test();
    private static int j = method();
    static {
        System.out.print(" 6 ;");
    }
    SonDemo(){
        System.out.print(" 7 ;");
    }//构造器默认调用父类的init方法，而且最后执行
    {
        System.out.print(" 8 ;");
    }
    public int test(){
        System.out.print(" 9 ;");
        return 1;
    }
    public static int method(){
        System.out.print(" 10 ;");
        return 2;
    }

    public static void main(String[] args){
        SonDemo s1 = new SonDemo();
        System.out.println();
        SonDemo s2 = new SonDemo();
    }
}

package com.company;

//import net.sf.cglib.proxy.Enhancer;

public class MetaspaceOOMDemo {
    static class OOMTest{

    }
    public static void main(String[] args){
        int i = 0;
        try {
            while (true){
                i++;
//                Enhancer enhancer = new Enhancer();
//                enhancer.setSuperClass(OOMTest.class);
//                enhancer.setUseCache(false);
//                enhancer.setCallback(new MethodInterceptor(){
//
//                });
//                enhancer.create();
            }
        }catch (Throwable e){
            System.out.println("*******************多少次后发生异常："+i);
            e.printStackTrace();
        }
    }
}

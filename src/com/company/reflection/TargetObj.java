package com.company.reflection;

public class TargetObj {
    private String value;

    public TargetObj(String value) {
        value = "Test Reflection";
    }

    public void publiMethod(String s){
        System.out.println("I love " + s);
    }

    private void privateMethod(){
        System.out.println("value is "+ value);
    }

}

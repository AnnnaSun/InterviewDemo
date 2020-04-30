package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int i=1;
        i = i++;
        int j = i++;
        int k = i+ ++i * i++;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }
}

package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.WeakHashMap;

public class WeakHashMapDemo {

    public static void main(String[] args){
        myhash();
        System.out.println("===========================");
        myWeakHashMap();
    }

    private static void myhash(){
        HashMap<Integer, String> hashMap = new HashMap();
        Integer key = new Integer(1);
        String value = "HashMap";
        hashMap.put(key, value);
        System.out.println(hashMap);

        key=null;
        System.out.println(hashMap);
        System.gc();
        System.out.println(hashMap+"\t "+hashMap.size());
    }

    private static void myWeakHashMap(){
        WeakHashMap<Integer, String> hashMap = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "WeakHashMap";
        Integer key2 = new Integer(3);

        hashMap.put(key, value);
        hashMap.put(key2,value);
        System.out.println(hashMap);

        key=null;
        key2 = null;
        System.out.println(hashMap);
        System.gc();
        System.out.println(hashMap+"\t "+hashMap.size());
    }
}

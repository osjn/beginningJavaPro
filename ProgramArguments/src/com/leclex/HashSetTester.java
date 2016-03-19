package com.leclex;

import java.util.HashSet;

/**
 * Created by 乐成 on 2016/3/14.
 */
public class HashSetTester {
    public static void main(String[] args) {
        HashSet<String> mySet = new HashSet<>();
        mySet.add("A");
        mySet.add("B");
        mySet.add("C");
        mySet.add("A");
        System.out.println(mySet);
        mySet.remove("B");
        System.out.println(mySet);
        mySet.add("D");
        System.out.println(mySet);
    }
}

package com.leclex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by 乐成 on 2016/3/14.
 */
public class CollectionsTester {
    public static void main(String[] args) {
        ArrayList<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("first item");
        listOfStrings.add("second item");
        listOfStrings.add("third item");
        listOfStrings.add("fourth item");
        listOfStrings.remove(0);    // remove the first item

        HashSet<Integer> setOfIntegers = new HashSet<>();
        setOfIntegers.add(2);
        setOfIntegers.add(4);
        setOfIntegers.add(2);
        setOfIntegers.remove(2);

        HashMap<String, Integer> mapOfStringToInteger = new HashMap<>();
        mapOfStringToInteger.put("Alice", 4);
        mapOfStringToInteger.put("Bob", 3);
        mapOfStringToInteger.remove("Alice");
    }
}

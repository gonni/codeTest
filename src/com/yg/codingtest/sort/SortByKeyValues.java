package com.yg.codingtest.sort;

import java.util.Hashtable;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class SortByKeyValues {
    public static void main(String ... v) {
        Hashtable<String, Integer> htData = new Hashtable<>();
        htData.put("AA", 20);
        htData.put("CC", 10);
        htData.put("CA", 99);


        htData.forEach((key, val) -> {
            System.out.println(key + "=" + val);
        });

        System.out.println("Sorted by Value -------");
        Stream<Map.Entry<String, Integer>> sorted =
                htData.entrySet().stream().sorted(Map.Entry.comparingByValue());
        sorted.forEach(System.out::println);


        System.out.println("Sorted by Value Reversed -------");
        sorted =
                htData.entrySet().stream().sorted(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1)));
        sorted.forEach(System.out::println);



    }
}

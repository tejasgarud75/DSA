package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapHashSet {

  public static void main(String args[]) {
    Map map = new HashMap<>();
    map.put("Ea", 2);
    map.put("AA", 3);

    System.out.println(map.put("Ea", 3));

    map.forEach((i, j) -> System.out.println(i + " " + j));

        Object o = new Object();
        long l = o.hashCode();
        System.out.println(l);

        System.out.println("Ea".hashCode());
        System.out.println("FB".hashCode());

        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        var list1 = listOfLists.stream().flatMap(
                List::stream
        ).collect(Collectors.toList());
//
//        System.out.println(list1);

    int[] arr = {3, 2, 1, 5};
    sortArr(arr);

  }

  private static void sortArr(int[] arr) {

  }
}

package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SlotSortingTest {


  public static void main(String[] args) {

    Map<String, Integer> map = new HashMap<>();
    map.put("A", 4);
    map.put("B", 2);
    map.put("C", 3);
    map.put("D", 1);

    List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

    list.sort(Entry.comparingByValue());
    System.out.println(list);

  }
}

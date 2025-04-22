package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApiIntegration {

  static Map<Character, Integer> map = new HashMap<>();

  static {
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('C', 50);
  }


  public static void main(String args[]) {
//    System.out.println(romanToInt("X"));
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    var list1 = list.stream().filter(i -> i > 2)
        .reduce((a, b) -> a + b).get();

    System.out.println(list1);
  }

  private static int romanToInt(String iv) {

    int sum = 0;

    for (int i = 0; i < iv.length() - 1; i++) {
      if (map.get(iv.charAt(i)) < map.get(iv.charAt(i + 1))) {
        sum = sum - map.get(iv.charAt(i));
      } else {
        sum = sum + map.get(iv.charAt(i));
      }
    }

    return sum;
  }
}
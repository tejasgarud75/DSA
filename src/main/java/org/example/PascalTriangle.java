package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sound.midi.Soundbank;

public class PascalTriangle {


  public static void main(String[] args) {
//    System.out.println(pascal(5));
    System.out.println(getRow(30l));
    int nums[] = {1, 2, 1, 2, 5};

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (!map.containsKey(nums[i])) {
        map.put(nums[i], map.get(nums[i]) + 1);
      } else {
        map.put(nums[i], 1);
      }
    }

  }

  public static List<List<Integer>> pascal(int num) { // 2
    List<List<Integer>> listOfList = new ArrayList<>();

    if (num == 0) {
      return null;
    }

    //First List
    List<Integer> list = new ArrayList<>();
    list.add(1);
    listOfList.add(list);

    for (int i = 1; i < num; i++) { // i = 1 num = 2           [1,]

      List<Integer> list1 = new ArrayList<>();
      list1.addAll(list);

      int start = i;
      int divide = 1;
      int value = 1;

      while (start > 0) {
        value = value * start-- / divide++;
        list1.add(value);
      }
      listOfList.add(list1);

    }

    return listOfList;
  }

  public static List<Long> getRow(Long rowIndex) {

    List<Long> list = new ArrayList<>(); // 1 [ 1,]
    list.add(1L);

    Long start = rowIndex; // 1
    Long divide = 1l;
    Long value = 1l;

    while (start > 0) {   // 1
      value = value * start-- / divide++;
      list.add(value);
    }

    return list;
  }

}

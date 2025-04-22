package org.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Feature {

  public static void main(String args[]) throws FileNotFoundException {

    // Without lambda (using anonymous class)
  /*  Runnable task = new Runnable() {
      @Override
      public void run() {
        System.out.println("Hello from Runnable!");
      }
    };
*/
    // With lambda expression
//    Runnable taskLambda = () -> System.out.println("Hello from Runnable!");

    FunctionalInterface1 add = (a, b) -> a + b;
    FunctionalInterface1 sub = (a, b) -> a - b;

//    System.out.println(add.opp(1, 2));
//    System.out.println(sub.opp(3, 2));

//    List<Integer> a = List.of(1, 3, 1, 2, 2);


   /* var a1 = a.stream()
        .filter(i -> i == 1)
        .map(i -> i * 2)
        .collect(Collectors.toList());

    Stream<Integer> infiniteStream = Stream.iterate(1, n -> n + 1); // Infinite stream of numbers

    infiniteStream.limit(10)
        .forEach(System.out::println);

    System.out.println();*/

    int[] nums1 = {1, 2};
    int[] nums2 = {3, 4};

    int[] arr = new int[nums1.length + nums2.length];
    int counter = 0;
    int i = 0;
    int j = 0;

    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j]) {
        arr[counter++] = nums1[i++];
      } else {
        arr[counter++] = nums2[j++];
      }
    }

    if (i < nums1.length) {
      for (int k = i; k < nums1.length; k++) {
        arr[counter++] = nums1[i++];
      }
    }

    if (j < nums2.length) {
      for (int k = j; k < nums2.length; k++) {
        arr[counter++] = nums2[j++];
      }
    }

    int lengthArr = arr.length;
    double median = 0;
    if (lengthArr % 2 == 0) {

      int no1 = lengthArr / 2;
      int no2 = no1--;
      median = arr[no1] + arr[no2] / 2;
    } else {
      median = arr[(lengthArr - 1) / 2];
    }

    System.out.println(median);
  }


}


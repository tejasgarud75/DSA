package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hashing {


  public static void main(String args[]) {
    /*Scanner sc = new Scanner(System.in);
    int[] hash = new int[10];
    int[] arr = {1, 2, 2, 1, 2, 3, 5, 7};
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (!map.containsKey(arr[i])) {
        map.put(arr[i], 1);
      } else {
        map.put(arr[i], map.get(arr[i]) + 1);
      }

//      hash[arr[i]] += 1;
    }
    System.out.println(hash);

    String str1 = sc.next();
    charInString(str1);*/

//    System.out.println(fibRec(4));

    print(3);
    System.out.println();

  }

  public static void print(int n) {
    if (n <= 0) {
      return;
    }
    System.out.print("GFG ");
    print(n - 1);
  }

  public static void charInString(String str) {
    int[] arr = new int[256];
    for (int i = 0; i < str.length(); i++) {
      arr[str.charAt(i)] += 1;
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.println((char) (i) + " " + arr[i]);
    }
    System.out.println(str);
  }

  public static int fibRec(int no) {

    if (no <= 1) {
      return no;
    }
    int prev = fibRec(no - 1);
    int curr = fibRec(no - 2);

    return prev + curr;

  }


}

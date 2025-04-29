package org.example.multiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {


  public static void main(String[] args) {

    String str = "HELLOABC";

    List<Integer> list = List.of(1, 2, 3, 4, 5);

    var stream = list.stream();
    System.out.println(stream.filter(i -> i % 2 == 0).collect(Collectors.toList()));




   /* Counter counter = new Counter();

    ThreadClass thread1 = new ThreadClass(counter);
    ThreadClass thread2 = new ThreadClass(counter);

    thread1.start();
    thread2.start();
    try {
      thread2.join();
      thread1.join();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    System.out.println(counter.getCount());*/
  }

}

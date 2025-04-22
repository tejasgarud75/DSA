package org.example;

import java.util.Set;
import java.util.TreeSet;

public class C {

  public static void main(String[] args) {

    try {
      System.out.println("Hello");
      throw new RuntimeException("First");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Second");
    }
  }

}

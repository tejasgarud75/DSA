package org.example;

public class Main {

  public static void main(String[] args) {
    String str = "Abc";
    String str1 = "Abc";

    String str2 = new String("Abc");
    String str3 = str2;

    System.out.println(str2.equals(str3));
    System.out.println(str2 == str3);

  }

}
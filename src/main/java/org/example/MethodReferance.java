package org.example;


interface Parser {

  String parser(String str);
}

class ConvertString {

  public static String convertString(String str) {
    return "Converted " + str;
  }
}

class Convert {

  public void convert(String str, Parser p) {
    System.out.println(p.parser(str));
  }
}

public class MethodReferance {

  public static void main(String[] args) {
    String str = "Tejas";

    Convert c = new Convert();
    c.convert(str, ConvertString::convertString);


  }

}
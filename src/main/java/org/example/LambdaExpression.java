package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

interface abc {

  void show();

  default void show1() {
    System.out.println("r");
  }
}

/*class a implements abc {

  @Override
  public void show() {
    System.out.println("calling show...");
  }

}*/

public class LambdaExpression {

  public static void main(String args[]) {

//    abc a = () -> System.out.println("calling show ....");
//    a.show();

   /* Consumer<Integer> consumer = i -> System.out.println(i);

    // Consumer Interface
    List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);

    values.forEach(consumer);*/


  }

}
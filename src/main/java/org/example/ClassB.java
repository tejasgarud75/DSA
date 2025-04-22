package org.example;

class B {
  B() {
    System.out.println("B");
  }
}

class A extends B {

  A() {
    super();
    System.out.println("A");
  }
}

public class ClassB {

  public static void main(String[] args) {
    new A();
  }
}

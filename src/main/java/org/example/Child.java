package org.example;

public interface Child {
    static void sing() {
        System.out.println("Child sing");
    }

    default void write() {
        System.out.println("Child write");
    }
}

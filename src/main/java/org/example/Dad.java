package org.example;

public interface Dad {
    default void sing(){
        System.out.println("Dad sing");
    }
    default void write(){
        System.out.println("Dad write");
    }
}

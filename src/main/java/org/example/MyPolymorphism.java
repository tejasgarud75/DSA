package org.example;

import java.nio.channels.Pipe;

public class MyPolymorphism {

    public static void main(String args[]) {
        new Animal();
    }
}

class Animal{
    public void animalSound(){
        System.out.println("Animal ");
    }
}
class pig extends Animal{
    public void animalSound(){
        System.out.println("Pig ");
    }
}
class dog extends Animal{
    public void animalSound(){
        System.out.println("Dog ");
    }
}

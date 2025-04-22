package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.function.Consumer;

public class MyWindow {
    public static void main(String[] args) {
//        JFrame j = new JFrame("Window");
//        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        j.setVisible(true);

        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        for (int i = 1; i <= a.toArray().length; i++) {
            System.out.println("Using for " + i);
        }
        a.forEach((i) -> System.out.println("Using lambda " + i));

    }
}
package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Fibonacci {
    static int no = 2;


    public static void fibo(int prev, int next) {
        int newNo = prev + next;
        System.out.println(newNo);
        prev = next;
        next = newNo;
        if (no <= 10) {
            no++;
            fibo(prev, next);
        }
    }

    public static void main(String args[]) {

        int prev = 0, next = 1;
        System.out.println(prev);
        System.out.println(next);
//        fibo(prev, next);

        int newNo = 0;
        for (int i = 0; i < 18; i++) {
            newNo = prev + next;
            System.out.println(newNo);
            prev = next;
            next = newNo;
        }

    }

}

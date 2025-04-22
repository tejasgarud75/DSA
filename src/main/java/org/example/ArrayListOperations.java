package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayListOperations {


    public static void heapExample() {
        long[] largeNumbers = new long[1000000];
        // Populate the array
        for (int i = 0; i < largeNumbers.length; i++) {
            largeNumbers[i] = i + 1;
        }
        // Perform some calculations
        long sum = 0;
        for (long num : largeNumbers) {
            sum += num;
        }
        System.out.println("Sum of large numbers (Heap): " + sum);
    }

    // Storing large numbers in variables on the stack
    public static void stackExample() {
        long sum = 0;
        // Perform some calculations
        for (int i = 1; i <= 1000000; i++) {
            sum += i;
        }
        System.out.println("Sum of large numbers (Stack): " + sum);
    }

    public static void main(String[] args) {
        long startTime, endTime, totalTime;

        // Heap Example
        startTime = System.currentTimeMillis();
        heapExample();
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("Time taken for heap example: " + totalTime + "ms");

        // Stack Example
        startTime = System.currentTimeMillis();
        stackExample();
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("Time taken for stack example: " + totalTime + "ms");
    }


}

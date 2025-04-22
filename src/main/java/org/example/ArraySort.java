package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraySort {

  public static void main(String[] args) {
//    int[] x = {5, 3, 2, 19, 7, 5, 1};

    int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    int len = arr.length;
//    funRev(arr, 0);

//    sortArray(x);
//    sortArrayInsertion(x);
    /*  sortArrayMerge(x, 0, x.length - 1);*/

//    for (var i : arr) {
//      System.out.println(i);
//    }

    int no = 10;
    fibNum(no);

  }

  private static void fibNum(int no) {
    int first = 0;
    int sec = 1;
    System.out.println(first);
    System.out.println(sec);
    for (int i = 2; i < no; i++) {
      var temp = sec;
      sec = first + sec;
      first = temp;
      System.out.println(sec);
    }
  }

  private static void funRev(int[] arr, int i) {
    if (i > arr.length / 2) {
      return;
    }
    swapArr1(arr, i);
    i++;
    funRev(arr, i);
  }

  private static void swapArr1(int[] arr, int i) {
    int temp = arr[i];
    arr[i] = arr[arr.length - i - 1];
    arr[arr.length - i - 1] = temp;
  }


  private static void sortArrayMerge(int[] arr, int low, int high) {
    if (low >= high) {
      return;
    }
    int mid = (low + high) / 2;
    sortArrayMerge(arr, low, mid);
    sortArrayMerge(arr, mid + 1, high);
    mergeArr(arr, low, mid, high);

  }

  private static void mergeArr(int[] arr, int low, int mid, int high) {

    ArrayList<Integer> temp = new ArrayList<>();
    int leftPtr = low;
    int rightPtr = mid + 1;
    // Merge elements into temp array
    while (leftPtr <= mid && rightPtr <= high) {
      if (arr[leftPtr] < arr[rightPtr]) {
        temp.add(arr[leftPtr++]);
      } else {
        temp.add(arr[rightPtr++]);
      }
    }
    // Copy remaining elements from the left half
    while (leftPtr <= mid) {
      temp.add(arr[leftPtr++]);
    }
    // Copy remaining elements from the right half
    while (rightPtr <= high) {
      temp.add(arr[rightPtr++]);
    }

    // Copy sorted elements back to the original array
    for (int i = 0; i < temp.size(); i++) {
      arr[low + i] = temp.get(i);
    }

  }

  private static void sortArray(int[] arr) {

    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        if (arr[j] < arr[i]) {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }

  private static void sortArrayInsertion(int[] arr) {
    int count = arr.length;
    for (int i = 0; i < count; i++) {
      int j = i;
      while (j > 0 && arr[j - 1] > arr[j]) {
        var temp = arr[j - 1];
        arr[j - 1] = arr[j];
        arr[j] = temp;
        j--;
      }

    }
  }
}






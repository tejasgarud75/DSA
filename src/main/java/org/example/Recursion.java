package org.example;

public class Recursion {


  public static void main(String args[]) {
    int no = 5;
//    recursion(no, no);
//    sumWithRecursion(3, 0);
//    System.out.println(sumWithFunctionRecursion(4));

//    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
//    functionRev(0, arr);

//    boolean str = funRevPalString(0, "MAaaAM");

    System.out.println(fibNo(3));
  }

  private static int fibNo(int no) {
    if (no <= 1) {
      return no;
    }
    int first = fibNo(no - 1);
    int second = fibNo(no - 2);
    return first + second;
  }

  private static boolean funRevPalString(int i, String str) {
    if (i >= str.length() / 2) {
      return true;
    }
    if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
      return false;
    }
    return funRevPalString(i + 1, str);
  }


  private static void functionRev(int i, int[] arr) {
    if (i > arr.length / 2) {
      return;
    }
    swapArr(i, arr);
    i++;
    functionRev(i, arr);
  }

  private static void swapArr(int i, int[] arr) {
    var temp = arr[arr.length - i - 1];
    arr[arr.length - i - 1] = arr[i];
    arr[i] = temp;
  }

  public static void recursion(int i, int no) {
    if (i > 0) {
      return;
    }

    System.out.println(i);
    recursion(i + 1, no);
  }

  public static void sumWithRecursion(int no, int sum) {
    if (no < 1) {
      System.out.println(sum);
      return;
    }
    sum = sum + no;
    sumWithRecursion(no - 1, sum);
  }

  public static int sumWithFunctionRecursion(int no) {
    if (no < 1) {
      return 1;
    }
    return no * sumWithFunctionRecursion(no - 1);
  }


}

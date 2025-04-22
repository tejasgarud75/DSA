package org.example;

public class Digits {


  public static void main(String args[]) {
    int no = 5;
    String str = "";

//    patter1(no);
//    divisor(no);
//    System.out.println(greatestCommonDivisor(4, 10));
//    System.out.println(lcm(4, 10));
//    System.out.println(divisor1(no));

//    System.out.println(gcdEquilatterial(13, 17));

//    recursion(no, no);
    sumWithRecursion(3, 0);
    System.out.println(sumWithFunctionRecursion(4));
  }

//  public static void recursion(int no) {
//    if (no < 1) {
//      return;
//    }
//    System.out.println(no);
//    no--;
//    recursion(no);
//  }

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


  public static void patter1(int no) {
    var temp = no;
    int count = 0;
    while (temp > 0) {
      count++;
      temp = temp / 10;
    }

    System.out.println(count);
  }

  public static void divisor(int no) {
    for (int i = 1; i <= no / 2; i++) {
      if (no % i == 0) {
        System.out.print(i + " ");
      }
    }
    System.out.print(no);
    System.out.println();
  }

  public static int divisor1(int n) {

    int sum = 0;

    if (n == 0) {
      return 0;
    }

    for (int i = 1; i <= n; i++) {

      for (int j = 1; j <= i / 2; j++) {
        if (i % j == 0) {
          sum = sum + j;
        }
      }
      sum = sum + i;
    }

    return sum;
  }

  public static int greatestCommonDivisor(int n1, int n2) {

    int greaterNo = n1 >= n2 ? n1 : n2;
    int gcd = 1;

    for (int i = 1; i <= greaterNo; i++) {
      if (n1 % i == 0 && n2 % i == 0) {
        gcd = i;
      }
    }
    return gcd;
  }

  public static int[] lcm(int n1, int n2) {

    int lcm = (n1 * n2) / greatestCommonDivisor(n1, n2);

    return new int[]{lcm, greatestCommonDivisor(n1, n2)};
  }

  public static int gcdEquilatterial(int n1, int n2) {

    while (n1 > 0 && n2 > 0) {
      if (n1 > n2) {
        n1 = n1 - n2;
      } else {
        n2 = n2 - n1;
      }
      if (n1 == 0) {
        return n2;
      } else if (n2 == 0) {
        return n1;
      }
    }
    return 0;
  }


}
